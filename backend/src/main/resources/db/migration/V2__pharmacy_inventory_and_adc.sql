-- V2: Enterprise Pharmacy FEFO Batch Inventory, ADC Vault & Controlled Substances
CREATE TABLE IF NOT EXISTS pharmacy_formulary_master (
    id BIGSERIAL PRIMARY KEY,
    rx_cui VARCHAR(32) NOT NULL UNIQUE,
    generic_name VARCHAR(128) NOT NULL,
    brand_name VARCHAR(128),
    atc_classification VARCHAR(32),
    dosage_form VARCHAR(32),
    strength_concentration VARCHAR(32),
    route_of_administration VARCHAR(32),
    dea_schedule_tier VARCHAR(16) DEFAULT 'NON_CONTROLLED',
    is_high_alert_medication BOOLEAN DEFAULT FALSE,
    is_lookalike_soundalike BOOLEAN DEFAULT FALSE,
    requires_dual_nurse_signoff BOOLEAN DEFAULT FALSE,
    standard_unit_price_inr NUMERIC(10, 2) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS pharmacy_inventory_batches (
    id BIGSERIAL PRIMARY KEY,
    batch_lot_number VARCHAR(64) NOT NULL,
    rx_cui VARCHAR(32) NOT NULL REFERENCES pharmacy_formulary_master(rx_cui),
    manufacturer_name VARCHAR(128) NOT NULL,
    manufacture_date DATE NOT NULL,
    expiration_date DATE NOT NULL,
    quantity_received INTEGER NOT NULL,
    quantity_on_hand INTEGER NOT NULL,
    quantity_allocated INTEGER DEFAULT 0,
    unit_cost_inr NUMERIC(10, 2) NOT NULL,
    warehouse_location_bin VARCHAR(32),
    fefo_priority_rank INTEGER DEFAULT 100,
    is_quarantined BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_pharmacy_fefo_expiry ON pharmacy_inventory_batches(expiration_date, fefo_priority_rank);
