import boto3
import psycopg2
import os
import path

# Define your AWS credentials
aws_access_key_id = 'ACCESS_KEY_ID'
aws_secret_access_key = 'SECRET_ACCESS_KEY'

# Define your Redshift connection parameters
redshift_host = 'REDSHIFT_HOST'
redshift_port = 'REDSHIFT_PORT'
redshift_dbname = 'REDSHIFT_DBNAME'
redshift_user = 'REDSHIFT_USERNAME'
redshift_password = 'REDSHIFT_PASSWORD'

# Define the S3 bucket and file path
s3_bucket = 'ENTERBUCKNAMEHERE'
s3_key = 'dim_date.csv'

# Initialize the S3 and Redshift clients
s3 = boto3.client('s3', aws_access_key_id=aws_access_key_id, aws_secret_access_key=aws_secret_access_key)
redshift_conn = psycopg2.connect(
    host=redshift_host,
    port=redshift_port,
    dbname=redshift_dbname,
    user=redshift_user,
    password=redshift_password
)
redshift_cursor = redshift_conn.cursor()

# copy command to create dim_date
dim_date_query = """
COPY dim_date 
FROM 's3://{}/{}'
ACCESS_KEY_ID '{}'
SECRET_ACCESS_KEY '{}'
DELIMITER ','
IGNOREHEADER 1
TIMEFORMAT 'auto';
""".format(s3_bucket, s3_key, aws_access_key_id, aws_secret_access_key)

redshift_cursor.execute(dim_date_query)
redshift_conn.commit()

# dim_time_query
dim_time_query = """
COPY dim_time 
FROM 's3://{}/{}'
ACCESS_KEY_ID '{}'
SECRET_ACCESS_KEY '{}'
DELIMITER ','
IGNOREHEADER 1
TIMEFORMAT 'auto';
""".format(s3_bucket, s3_key, aws_access_key_id, aws_secret_access_key)



redshift_cursor.execute(dim_time_query)
redshift_conn.commit()

# Close connections
redshift_cursor.close()
redshift_conn.close()