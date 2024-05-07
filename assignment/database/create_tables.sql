-- Date table

CREATE TABLE IF NOT EXISTS dim_date(
    dim_date_key INT PRIMARY KEY NOT NULL,
    calendar_date DATETIME NOT NULL,
    cal_year INT NOT NULL,
    cal_week_in_year INT NOT NULL,
    cal_day_in_year INT NOT NULL,
    cal_month_no INT NOT NULL,
    cal_month_name VARCHAR(20) NOT NULL,
    cal_month_abv VARCHAR(3) NOT NULL,
    cal_day_of_week VARCHAR(20) NOT NULL,
    cal_day_of_month INT NOT NULL,
    cal_day_in_week_no INT NOT NULL
)

-- Time table
CREATE TABLE IF NOT EXISTS dim_time (
    dim_time_key INT PRIMARY KEY NOT NULL,
    time_hhmm INT,
    time_hh INT,
    time_hh_24 INT,
    time_am_pm VARCHAR(2)
)

-- Business table. Only one business currently will go in here
CREATE TABLE IF NOT EXISTS dim_business(
    business_id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(200),
    address VARCHAR(200),
    city VARCHAR(200),
    state VARCHAR(200),
    postal_code VARCHAR(200),
    type VARCHAR(100)
)

-- User Table
CREATE TABLE IF NOT EXISTS dim_customer(
    customer_id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(200),
    email VARCHAR(200),
    phone_number VARCHAR(50),
    modified_at DATETIME,
    created_at DATETIME
)

-- facility / playground table
CREATE TABLE IF NOT EXISTS dim_facility(
    facility_id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(200),
    type VARCHAR(200)
);



-- Fact table for booking in EDW

CREATE TABLE IF NOT EXISTS fact_bookings (
    booking_id INT PRIMARY KEY,
    business_id INT,
    customer_id INT,
    dim_date_key INT,
    dim_time_key INT,
    facility_id INT,
    length_of_booking_minutes INT,
    number_of_people INT
    -- Additional columns for measures or other attributes
    
    FOREIGN KEY (business_id) REFERENCES dim_customers(business_id),
    FOREIGN KEY (customer_id) REFERENCES dim_customers(customer_id),
    FOREIGN KEY (dim_date_key) REFERENCES dim_products(dim_date_key),
    FOREIGN KEY (dim_time_key) REFERENCES dim_products(dim_time_key),
    FOREIGN KEY (facility_id) REFERENCES dim_products(facility_id),
    
);