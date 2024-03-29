-- Вставка данных в таблицу document
INSERT INTO document (number, date, amount, note) VALUES ('DOC001', '2024-04-01', 1000.00, 'Примечание к документу 1');
INSERT INTO document (number, date, amount, note) VALUES ('DOC002', '2024-04-02', 1500.50, 'Примечание к документу 2');
INSERT INTO document (number, date, amount, note) VALUES ('DOC003', '2024-04-03', 2000.75, 'Примечание к документу 3');

-- Получение ID вставленных документов
SELECT id FROM document WHERE number IN ('DOC001', 'DOC002', 'DOC003');

-- Вставка данных в таблицу position, предполагая, что документы с ID 1, 2 и 3 соответственно
INSERT INTO position (document_id, number, name, amount) VALUES (1, 'POS001', 'Позиция документа 1', 500.25);
INSERT INTO position (document_id, number, name, amount) VALUES (1, 'POS002', 'Позиция документа 2', 300.50);
INSERT INTO position (document_id, number, name, amount) VALUES (2, 'POS003', 'Позиция документа 3', 700.75);
INSERT INTO position (document_id, number, name, amount) VALUES (3, 'POS004', 'Позиция документа 4', 1000.00);
