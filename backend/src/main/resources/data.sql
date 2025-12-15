INSERT INTO pcb_type (name) VALUES ('TestBoard');
INSERT INTO pcb_type (name) VALUES ('SensorBoard');
INSERT INTO pcb_type (name) VALUES ('GatewayBoard');

INSERT INTO failure_rate (pcb_type_id, station_name, failure_rate) VALUES (1, 'PlaceComponents', 0.05);
INSERT INTO failure_rate (pcb_type_id, station_name, failure_rate) VALUES (1, 'OpticalInspection', 0.10);
INSERT INTO failure_rate (pcb_type_id, station_name, failure_rate) VALUES (1, 'HandSolderAssembly', 0.05);
INSERT INTO failure_rate (pcb_type_id, station_name, failure_rate) VALUES (1, 'TestICTFlyingProbe', 0.10);

INSERT INTO failure_rate (pcb_type_id, station_name, failure_rate) VALUES (2, 'PlaceComponents', 0.002);
INSERT INTO failure_rate (pcb_type_id, station_name, failure_rate) VALUES (2, 'OpticalInspection', 0.002);
INSERT INTO failure_rate (pcb_type_id, station_name, failure_rate) VALUES (2, 'HandSolderAssembly', 0.004);
INSERT INTO failure_rate (pcb_type_id, station_name, failure_rate) VALUES (2, 'TestICTFlyingProbe', 0.004);

INSERT INTO failure_rate (pcb_type_id, station_name, failure_rate) VALUES (3, 'PlaceComponents', 0.004);
INSERT INTO failure_rate (pcb_type_id, station_name, failure_rate) VALUES (3, 'OpticalInspection', 0.004);
INSERT INTO failure_rate (pcb_type_id, station_name, failure_rate) VALUES (3, 'HandSolderAssembly', 0.008);
INSERT INTO failure_rate (pcb_type_id, station_name, failure_rate) VALUES (3, 'TestICTFlyingProbe', 0.008);
