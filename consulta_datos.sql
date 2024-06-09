-- Obtener reservaciones de una propiedad específica
SELECT * FROM reservaciones WHERE propiedad_id = 1;

-- Obtener propiedades de un estado específica
SELECT * FROM propiedades WHERE estado = 'disponible';

-- Listar todas las propiedades de una agencia específica
SELECT * FROM propiedades WHERE agencia_id = 1;