-- Borrar reservaciones de una propiedad específica
DELETE FROM reservaciones WHERE id = 1;

-- Borrar propiedades de un estado específica
SELECT * FROM propiedades WHERE estado = 'disponible';

-- Borrar todas las propiedades de una agencia específica
SELECT * FROM propiedades WHERE agencia_id = 1;
