INSERT INTO USER(id, password , username)VALUES
(1, '$2a$10$iDftc21ZWsWN9Dl6mM5XNe8bfjGKbdRxmqEVb4NpuiYwBhSdjJGjS','client'),
(2, '$2a$10$pWlq/UMgRSGT797NuQLSVOPpQcXeZ6X3zj6yZs3/jHuq9cChZBX7q','admin');

INSERT INTO ROLE(id, role, user_id)VALUES
(1, 'CLIENT', 1),
(2, 'ADMIN', 2);