INSERT INTO users(id, password , username)VALUES
(1, '$2a$10$B16PleEROhDaNbRs.pGGXeRTMAJEXeX9Hox8Vx9ItkikCctbHXf16','pepe'),
(2, '$2a$10$PNCP/gwXOMfbP1W0gssOde7D9lv4vvs7v5i3anZby9zcgKvO4zD.y','jorge');

INSERT INTO ROLE(id, role, user_id)VALUES
(1, 'CLIENT', 1),
(2, 'ADMIN', 2);