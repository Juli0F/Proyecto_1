
CREATE SCHEMA IF NOT EXISTS TiendaProyecto  ;
USE TiendaProyecto;

CREATE TABLE IF NOT EXISTS Persona (
  dpi VARCHAR(15) NOT NULL,
  nombre VARCHAR(45) NULL DEFAULT NULL,
  telefono VARCHAR(45) NULL DEFAULT NULL,
  direccion VARCHAR(45) NULL DEFAULT NULL,
  estado TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (dpi))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS Cliente (
  nit VARCHAR(15) NOT NULL,
  credito DECIMAL(15,7) NULL DEFAULT 0.0000000,
  email VARCHAR(45) NULL DEFAULT NULL,
  estado TINYINT(4) NULL DEFAULT 1,
  Persona_dpi VARCHAR(15) NOT NULL,
  PRIMARY KEY (nit),
  INDEX fk_Cliente_Persona1_idx (Persona_dpi ASC),
  CONSTRAINT fk_Cliente_Persona1
    FOREIGN KEY (Persona_dpi)
    REFERENCES Persona (dpi)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



CREATE TABLE IF NOT EXISTS Empleado (
  idUsuarioSystem INT(11) NOT NULL AUTO_INCREMENT,
  codigoEmpleado VARCHAR(45) NULL DEFAULT NULL,
  nit VARCHAR(45) NULL DEFAULT NULL,
  email VARCHAR(45) NULL DEFAULT NULL,
  tipo VARCHAR(45) NULL DEFAULT NULL,
  estado TINYINT(4) NULL DEFAULT 1,
  Persona_dpi VARCHAR(15) NOT NULL,
  PRIMARY KEY (idUsuarioSystem),
  INDEX fk_UsuarioSystem_Persona1_idx (Persona_dpi ASC),
  CONSTRAINT fk_UsuarioSystem_Persona1
    FOREIGN KEY (Persona_dpi)
    REFERENCES Persona (dpi)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS Usuario (
  idUsuario INT(11) NOT NULL AUTO_INCREMENT,
  usuario VARCHAR(45) NULL DEFAULT NULL,
  password VARCHAR(45) NULL DEFAULT NULL,
  tipo INT(11) NULL DEFAULT NULL,
  estado VARCHAR(45) NULL DEFAULT NULL,
  email VARCHAR(45) NULL DEFAULT NULL,
  Persona_dpi VARCHAR(15) NOT NULL,
  PRIMARY KEY (idUsuario),
  INDEX fk_Usuario_Persona1_idx (Persona_dpi ASC),
  CONSTRAINT fk_Usuario_Persona1
    FOREIGN KEY (Persona_dpi)
    REFERENCES Persona (dpi)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS Producto (
  codigo VARCHAR(30) NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  fabricante VARCHAR(45) NOT NULL,
  Descripcion VARCHAR(45) NULL DEFAULT NULL,
  Garantia INT(11) NULL DEFAULT NULL,
  estado TINYINT(4) NULL DEFAULT 1,
  PRIMARY KEY (codigo),
  UNIQUE INDEX codigo_UNIQUE (codigo ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS TiempoDeEnvio (
  idTiempoDeEnvio INT(11) NOT NULL AUTO_INCREMENT,
  tiempo INT(11) NULL DEFAULT NULL,
  estado TINYINT(4) NULL DEFAULT 1,
  descripcion VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (idTiempoDeEnvio))
ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS Tienda (
  codigo VARCHAR(15) NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  direccion VARCHAR(45) NOT NULL,
  telefono VARCHAR(45) NULL DEFAULT NULL,
  telefono2 VARCHAR(45) NULL DEFAULT NULL,
  email VARCHAR(45) NULL DEFAULT NULL,
  horario VARCHAR(45) NULL DEFAULT NULL,
  estado TINYINT(4) NULL DEFAULT 1,
  PRIMARY KEY (codigo),
  UNIQUE INDEX codigo_UNIQUE (codigo ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS StockTienda (
  idStockTienda INT(11) NOT NULL AUTO_INCREMENT,
  Tienda_codigo VARCHAR(15) NOT NULL,
  estado TINYINT(4) NOT NULL DEFAULT 1,
  precio DECIMAL(18,7) NOT NULL,
  cantidad INT(11) NOT NULL,
  Producto_codigo VARCHAR(30) NOT NULL,
  PRIMARY KEY (idStockTienda),
  INDEX fk_StockTienda_Tienda_idx (Tienda_codigo ASC),
  INDEX fk_StockTienda_Producto1_idx (Producto_codigo ASC),
  CONSTRAINT fk_StockTienda_Producto1
    FOREIGN KEY (Producto_codigo)
    REFERENCES Producto (codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_StockTienda_Tienda
    FOREIGN KEY (Tienda_codigo)
    REFERENCES Tienda (codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS TiempoEntreTiendas (
  idTiempoEntreTiendas INT(11) NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(45) NULL DEFAULT NULL,
  TiempoDeEnvio_idTiempoDeEnvio INT(11) NOT NULL,
  Tienda_codigo VARCHAR(15) NOT NULL,
  PRIMARY KEY (idTiempoEntreTiendas),
  INDEX fk_TiempoEntreTiendas_TiempoDeEnvio1_idx (TiempoDeEnvio_idTiempoDeEnvio ASC),
  INDEX fk_TiempoEntreTiendas_Tienda1_idx (Tienda_codigo ASC),
  CONSTRAINT fk_TiempoEntreTiendas_TiempoDeEnvio1
    FOREIGN KEY (TiempoDeEnvio_idTiempoDeEnvio)
    REFERENCES TiempoDeEnvio (idTiempoDeEnvio)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_TiempoEntreTiendas_Tienda1
    FOREIGN KEY (Tienda_codigo)
    REFERENCES Tienda (codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS Factura (
  idFactura INT(11) NOT NULL AUTO_INCREMENT,
  total DECIMAL(18,7) NULL DEFAULT NULL,
  fecha DATE NULL DEFAULT NULL,
  descripcion VARCHAR(45) NULL DEFAULT NULL,
  estado TINYINT(4) NULL DEFAULT NULL,
  Usuario_idUsuario INT(11) NOT NULL,
  Tienda_codigo VARCHAR(15) NOT NULL,
  nit VARCHAR(15) NOT NULL,
  PRIMARY KEY (idFactura),
  INDEX fk_Factura_Usuario1_idx (Usuario_idUsuario ASC),
  INDEX fk_Factura_Tienda1_idx (Tienda_codigo ASC),
  INDEX nit (nit ASC),
  CONSTRAINT fk_Factura_Tienda1
    FOREIGN KEY (Tienda_codigo)
    REFERENCES Tienda (codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_Factura_Usuario1
    FOREIGN KEY (Usuario_idUsuario)
    REFERENCES Usuario (idUsuario)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT nit
    FOREIGN KEY (nit)
    REFERENCES Cliente (nit))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS DetalleFactura (
  idDetalleFactura INT(11) NOT NULL AUTO_INCREMENT,
  Factura_idFactura INT(11) NOT NULL,
  cantidad INT(11) NULL DEFAULT NULL,
  subtotal DECIMAL(18,7) NULL DEFAULT NULL,
  Producto_codigo VARCHAR(30) NOT NULL,
  PRIMARY KEY (idDetalleFactura),
  INDEX fk_DetalleFactura_Factura1_idx (Factura_idFactura ASC),
  INDEX fk_DetalleFactura_Producto1_idx (Producto_codigo ASC),
  CONSTRAINT fk_DetalleFactura_Factura1
    FOREIGN KEY (Factura_idFactura)
    REFERENCES Factura (idFactura)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_DetalleFactura_Producto1
    FOREIGN KEY (Producto_codigo)
    REFERENCES Producto (codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;



CREATE TABLE IF NOT EXISTS Pedido (
  codigo VARCHAR(30) NOT NULL,
  fecha DATE NULL DEFAULT NULL,
  entregado TINYINT(4) NULL DEFAULT 0,
  subtotal DECIMAL(18,7) NULL DEFAULT NULL,
  retraso INT(11) NULL DEFAULT NULL,
  destino TINYINT(4) NULL DEFAULT NULL,
  estado TINYINT(4) NULL DEFAULT 1,
  anticipo DECIMAL(18,7) NULL DEFAULT NULL,
  TiempoDeEnvio_idTiempoDeEnvio INT(11) NOT NULL,
  Cliente_nit VARCHAR(15) NOT NULL,
  Tienda_codigo VARCHAR(15) NOT NULL,
  PRIMARY KEY (codigo),
  INDEX fk_Pedido_TiempoDeEnvio1_idx (TiempoDeEnvio_idTiempoDeEnvio ASC),
  INDEX fk_Pedido_Cliente1_idx (Cliente_nit ASC),
  INDEX fk_Pedido_Tienda1_idx (Tienda_codigo ASC),
  CONSTRAINT fk_Pedido_Cliente1
    FOREIGN KEY (Cliente_nit)
    REFERENCES Cliente (nit)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_Pedido_TiempoDeEnvio1
    FOREIGN KEY (TiempoDeEnvio_idTiempoDeEnvio)
    REFERENCES TiempoDeEnvio (idTiempoDeEnvio)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_Pedido_Tienda1
    FOREIGN KEY (Tienda_codigo)
    REFERENCES Tienda (codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS DetallePedido (
  idDetallePedido INT(11) NOT NULL AUTO_INCREMENT,
  cantidad INT(11) NULL DEFAULT NULL,
  estado TINYINT(4) NULL DEFAULT NULL,
  Producto_codigo VARCHAR(30) NOT NULL,
  Pedido_codigo VARCHAR(30) NOT NULL,
  PRIMARY KEY (idDetallePedido, Producto_codigo),
  INDEX fk_DetallePedido_Producto1_idx (Producto_codigo ASC),
  INDEX fk_DetallePedido_Pedido1_idx (Pedido_codigo ASC),
  CONSTRAINT fk_DetallePedido_Pedido1
    FOREIGN KEY (Pedido_codigo)
    REFERENCES Pedido (codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_DetallePedido_Producto1
    FOREIGN KEY (Producto_codigo)
    REFERENCES Producto (codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB

DEFAULT CHARACTER SET = utf8;


