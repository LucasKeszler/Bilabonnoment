INSERT INTO medarbejder (username, password, rolle)
VALUES ('admin', 'Password123', 'ADMIN');

INSERT INTO medarbejder (username, password, rolle)
VALUES ('dataregistrering', 'Password123', 'DATAREGISTRERING');

INSERT INTO medarbejder (username, password, rolle)
VALUES ('skade', 'Password123', 'SKADE');

INSERT INTO medarbejder (username, password, rolle)
VALUES ('business', 'Password123', 'BUSINESS');

INSERT INTO kunde (navn, email, telefon) VALUES
                                             ('Mads Jensen', 'mads.jensen@test.dk', '22334455'),
                                             ('Sofie Andersen', 'sofie.andersen@test.dk', '33445566'),
                                             ('Emma Larsen', 'emma.larsen@test.dk', '44556677'),
                                             ('Jonas Nielsen', 'jonas.nielsen@test.dk', '55667788'),
                                             ('Frederik Hansen', 'frederik.hansen@test.dk', '66778899'),
                                             ('Laura Petersen', 'laura.petersen@test.dk', '77889900');

INSERT INTO bil (
    vognummer,
    stelnummer,
    maerke,
    model,
    nummerplade,
    status,
    lokation,
    maanedspris
) VALUES
      ('VOG-1001', 'VF1RJA001ABC10001', 'Renault', 'Clio', 'AB12345', 'UDLEJET', 'København', 2799.00),
      ('VOG-1002', 'VF3P20801ABC10002', 'Peugeot', '208', 'CD23456', 'LEDIG', 'Odense', 3199.00),
      ('VOG-1003', 'VR7C30001ABC10003', 'Citroën', 'C3', 'EF34567', 'SKADET', 'FDM Taastrup', 2999.00),
      ('VOG-1004', 'W0VCORSA1ABC10004', 'Opel', 'Corsa', 'GH45678', 'UDLEJET', 'Aarhus', 2899.00),
      ('VOG-1005', 'LSJW74091ABC10005', 'MG', 'ZS EV', 'IJ56789', 'TILBAGELEVERET', 'FDM Odense', 3999.00),
      ('VOG-1006', 'VF1MEGANEABC10006', 'Renault', 'Megane E-Tech', 'KL67890', 'UDLEJET', 'København', 4599.00),
      ('VOG-1007', 'VF3P30081ABC10007', 'Peugeot', '3008', 'MN78901', 'RESERVERET', 'Aalborg', 5299.00),
      ('VOG-1008', 'VR7DS4001ABC10008', 'DS', 'DS 4', 'OP89012', 'LEDIG', 'DS Salon København', 4899.00);

INSERT INTO lejeaftale (
    kunde_id,
    bil_id,
    startdato,
    slutdato,
    pris,
    afhentningssted,
    afleveringssted,
    status
) VALUES
      (1, 1, '2026-01-15', '2026-06-15', 13995.00, 'København', 'København', 'AKTIV'),
      (2, 4, '2026-02-01', '2026-07-01', 14495.00, 'Aarhus', 'Aarhus', 'AKTIV'),
      (3, 6, '2026-03-01', '2027-03-01', 52428.60, 'København', 'København', 'AKTIV'),
      (4, 3, '2025-11-01', '2026-04-01', 14995.00, 'København', 'FDM Taastrup', 'AFSLUTTET'),
      (5, 5, '2025-12-10', '2026-05-10', 19995.00, 'Odense', 'FDM Odense', 'AFSLUTTET');

INSERT INTO skade (
    lejeaftale_id,
    beskrivelse,
    pris,
    dato
) VALUES
      (4, 'Ridse på højre fordør', 2500.00, '2026-04-02'),
      (4, 'Stenslag i forrude', 3200.00, '2026-04-02'),
      (5, 'Ridset alufælg foran venstre', 800.00, '2026-05-11');