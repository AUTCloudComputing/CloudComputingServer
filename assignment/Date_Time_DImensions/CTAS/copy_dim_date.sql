-- Populates the Redshift table for the date dimension from a csv file located in an S3 bucket

COPY dim_date 
FROM 's3://ENTERBUCKNAMEHERE/dim_date.csv'
access_key_id
secret_access_key
DELIMITER ','
IGNOREHEADER 1
TIMEFORMAT 'auto'


-- Populate the Redshift table for the time dimension from a csv file located in an S3 bucket

COPY dim_date 
FROM 's3://ENTERBUCKNAMEHERE/dim_time.csv'
access_key_id
secret_access_key
DELIMITER ','
IGNOREHEADER 1
TIMEFORMAT 'auto'
