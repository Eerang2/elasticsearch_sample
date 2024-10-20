drop table if exists ACCOMMODATION CASCADE;
CREATE TABLE ACCOMMODATION (
                               acmd_no BIGINT AUTO_INCREMENT PRIMARY KEY,
                               name VARCHAR(100) NOT NULL,
                               description VARCHAR(1000) NOT NULL,
                               accommodation_type VARCHAR(255) NOT NULL,
                               is_free_parking BOOLEAN,
                               parking_type VARCHAR(255),
                               location_guide_text VARCHAR(255)
);
