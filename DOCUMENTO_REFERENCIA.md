Documento de Referencia: Sistema de Alquiler de Vehículos
1. DESCRIPCIÓN GENERAL DEL SISTEMA
El sistema modela una empresa de alquiler de vehículos que opera desde una única ubicación. La empresa gestiona una flota diversa de vehículos (autos, camionetas y motos) que pueden ser alquilados por clientes registrados, con la posibilidad de realizar reservas anticipadas, generar contratos, procesar pagos y gestionar devoluciones con cargos adicionales cuando corresponda.
El sistema permite el control completo del ciclo de vida del alquiler, desde la reserva inicial hasta la devolución del vehículo, incluyendo la gestión de mantenimientos, facturación, reportes gerenciales y un sistema de autenticación basado en roles.

2. ARQUITECTURA DEL MODELO
2.1 Entidades Principales
El modelo se estructura alrededor de las siguientes entidades principales:
Empresa
Representa la organización que opera el negocio de alquiler
Gestiona la flota completa de vehículos
Contiene configuraciones globales: tarifas, políticas, métodos de pago aceptados
Centraliza reportes y estadísticas de toda la operación
Usuarios y Autenticación
El sistema implementa un modelo de usuarios con control de acceso basado en roles:

Usuario: Credenciales de acceso al sistema
- Atributos: idUsuario, username, password, rol, fechaCreacion, ultimoAcceso, estado

Persona: Clase base abstracta que contiene datos personales comunes
- Atributos: idPersona, nombre, apellido, dni, email, telefono, direccion, fechaNacimiento
- Relación 1:1 con Usuario

Cliente: Persona que alquila vehículos (hereda de Persona)
- Atributos adicionales: idCliente, numeroLicencia, fechaVencimientoLicencia, tipoLicencia, historialAlquileres

Empleado: Clase abstracta para personal de la empresa (hereda de Persona)
- Atributos adicionales: legajo, salario, turno

Gerente: Administra la empresa, aprueba operaciones, genera reportes (hereda de Empleado)
- Atributos adicionales: idGerente, bonoRendimiento, fechaInicioComoGerente, metaVentasMensual

Administrativo: Gestiona reservas, contratos, facturación y atención al cliente (hereda de Empleado)
- Atributos adicionales: idAdministrativo, puesto, metaAlquileresMensual, cantidadClientesAtendidos, cantidadIdiomas

Técnico: Realiza mantenimientos e inspecciones de vehículos (hereda de Empleado)
- Atributos adicionales: idTecnico, especialidad, certificaciones, fechaInicioComoTecnico

Cada Persona tiene asociado un Usuario (relación 1:1) que controla el acceso al sistema según roles definidos en UsuarioRolEnum (ADMIN, CLIENTE, GERENTE, ADMINISTRATIVO, TECNICO).
El estado de usuarios se controla mediante EstadoUsuarioEnum (ACTIVO, INACTIVO, BLOQUEADO, SUSPENDIDO).
2.2 Gestión de Vehículos
Jerarquía de Vehículos
La clase abstracta Vehiculo se especializa en tres tipos concretos:

Vehiculo (abstracta): Clase base para todos los vehículos
- Atributos: idVehiculo, patente, marca, modelo, anio, precioDiario, capacidadTanque, categoria, estado

Auto: Vehículos de pasajeros
- Atributos adicionales: numeroPuertas, capacidadBaul

Camioneta: Vehículos de carga
- Atributos adicionales: capacidadCarga, esTodoTerreno

Moto: Motocicletas
- Atributos adicionales: idMoto, cantidadPasajeros, tieneSidecar, cilindrada

Cada vehículo tiene:
Categoría (CategoriaVehiculoEnum): ECONOMICO, SEDAN, SUV, CAMIONETA, LUJO, DEPORTIVO, MOTO_ESTANDAR, etc.
Estado (EstadoVehiculoEnum): DISPONIBLE, ALQUILADO, RESERVADO, EN_MANTENIMIENTO, EN_REPARACION, EN_LIMPIEZA, EN_INSPECCION, FUERA_DE_SERVICIO, DADO_DE_BAJA
Gestión de Flota
La clase Flota agrupa todos los vehículos de la empresa, permitiendo:
Consultar vehículos disponibles
Obtener vehículos en mantenimiento
Gestionar estados de los vehículos

2.3 Proceso de Alquiler
El proceso de alquiler sigue este flujo:

1. Reserva (opcional)
Clase Reserva: Permite al cliente reservar un vehículo anticipadamente
- Atributos: idReserva, fechaReserva, fechaInicio, fechaFin, diasReserva, costoEstimado, estado
- Relaciones: cliente (Cliente), vehiculo (Vehiculo)
- Estados: EstadoReservaEnum (PENDIENTE, CONFIRMADA, CANCELADA, CONVERTIDA_ALQUILER)
Puede convertirse en un alquiler efectivo

2. Alquiler
Clase Alquiler: Representa la operación central del negocio
- Atributos principales: idAlquiler, fechaAlquiler, fechaDevolucionPrevista, kilometrajeInicial, nivelCombustibleInicial, estadoAlquiler
- Atributos de devolución: fechaDevolucionReal, kilometrajeFinal, nivelCombustibleFinal, estadoVehiculo, observaciones
- Relaciones: cliente (Cliente), vehiculo (Vehiculo), contrato (Contrato 1:1), factura (Factura 1:1), cargosAdicionales (List<CargoAdicional>)
- Estado controlado por EstadoAlquilerEnum (PENDIENTE, ACTIVO, FINALIZADO, CANCELADO)
- Métodos importantes:
  * registrarDevolucion(...): Registra todos los datos de devolución
  * agregarCargo(...): Agrega un cargo adicional
  * calcularCargosAdicionales(): Calcula cargos según reglas de negocio
  * tieneDevolucion(): Verifica si ya se registró la devolución

3. Contrato
Clase Contrato: Documento legal del alquiler
- Atributos: idContrato, fechaInicio, fechaDevolucionPrevista, fechaDevolucionReal, kilometrajeInicial, nivelCombustibleInicial, costoEstimado, costoTotal, terminosCondiciones, firmaCliente, estado
- Relación 1:1 con Alquiler
- Estado: VIGENTE, FINALIZADO, CANCELADO

Nota: La devolución del vehículo se gestiona directamente en la clase Alquiler, que contiene todos los atributos necesarios para registrar:
- Fecha y hora real de devolución
- Kilometraje final
- Nivel de combustible final
- Estado del vehículo
- Observaciones
- Lista de cargos adicionales generados
2.4 Facturación y Pagos
Factura
Clase Factura: Documento fiscal asociado a cada alquiler (relación 1:1)
- Atributos: idFactura, fechaEmision, subtotal, impuestos, total, estado
- Relaciones: alquiler (Alquiler 1:1), detalles (List<DetalleFactura>)
- Estado: EstadoFacturaEnum (PENDIENTE, PAGADA, ANULADA, VENCIDA)
- Métodos importantes:
  * agregarDetalle(...): Agrega una línea de detalle
  * recalcularTotales(): Recalcula subtotal y total automáticamente

DetalleFactura
Cada factura contiene múltiples líneas de detalle (relación 1:N)
- Atributos: idDetalle, concepto, cantidad, precioUnitario, subtotal
Cada línea representa un concepto facturable:
- Alquiler base (días × tarifa diaria)
- Seguro adicional
- GPS
- Silla de bebé
- Cargos adicionales

CargoAdicional
Clase CargoAdicional: Cargos extras aplicados durante o después del alquiler
- Atributos: idCargo, tipo, descripcion, monto
- Tipos definidos en TipoCargoEnum:
  * DEVOLUCION_TARDIA
  * KILOMETRAJE_EXTRA
  * DANO_VEHICULO
  * COMBUSTIBLE
  * LIMPIEZA
- Cada cargo se convierte en una línea de DetalleFactura y se asocia al Alquiler

Pago
Clase Pago: Registra los pagos recibidos
- Una factura puede tener múltiples pagos (relación 1:N) para pagos parciales
- Métodos de pago: MetodoPagoEnum (EFECTIVO, TARJETA_CREDITO, TARJETA_DEBITO, TRANSFERENCIA)
- Incluye número de transacción y comprobante
2.5 Mantenimiento de Vehículos
Mantenimiento
Clase Mantenimiento: Registra todas las intervenciones técnicas en vehículos
Relación N:1 con Vehiculo (un vehículo tiene múltiples mantenimientos)
Relación N:1 con Tecnico (un técnico realiza múltiples mantenimientos)
Tipos: TipoMantenimientoEnum (PREVENTIVO, CORRECTIVO, REVISION, REPARACION)
Estados: EstadoMantenimientoEnum (PROGRAMADO, EN_PROCESO, COMPLETADO, CANCELADO)
Atributos:
Fechas de inicio y fin
Descripción del trabajo realizado
Costo del mantenimiento
Técnico responsable
Durante el mantenimiento, el vehículo cambia su estado a EN_MANTENIMIENTO, quedando no disponible para alquiler.
2.6 Reportes y Estadísticas
Reporte
Clase Reporte: Genera informes gerenciales
Tipos definidos en TipoReporteEnum:
DISPONIBILIDAD_VEHICULOS: Estado de flota
CONTRATOS_ACTIVOS: Alquileres en curso
INGRESOS_ALQUILER: Análisis financiero
MANTENIMIENTOS: Historial técnico
CLIENTES_FRECUENTES: Análisis de clientes
Formato de exportación: PDF y Excel

3. FUNCIONALIDADES IMPLEMENTADAS
3.1 Gestión de Usuarios
Actores: Gerente, Administrativo
Operaciones:
Registrar usuario: Crear nuevo Cliente o Empleado con credenciales de acceso
Modificar usuario: Actualizar datos personales y de contacto
Eliminar/Dar de baja usuario: Inactivar cuenta (baja lógica)
Asignar roles: Definir permisos según RolUsuarioEnum
Control de estado: Activar, suspender o bloquear usuarios
Auditoría: Todas las operaciones quedan registradas en RegistroAuditoria con:
Tipo de operación (TipoOperacionEnum: ALTA, BAJA, MODIFICACION)
Fecha y hora
Usuario responsable
Detalles del cambio
3.2 Gestión de Vehículos
Actores: Gerente, Administrativo, Técnico
Operaciones:
Alta de vehículo: Registrar nuevo vehículo en la flota


Seleccionar tipo (Auto, Camioneta, Moto)
Definir categoría y atributos específicos
Estado inicial: DISPONIBLE o EN_INSPECCION
Modificación: Actualizar datos del vehículo


Actualizar kilometraje
Modificar precio diario
Baja de vehículo: Retirar de operación


Cambiar estado a DADO_DE_BAJA
Mantener en base de datos para historial
Control de estado: El estado del vehículo cambia automáticamente según eventos:


Reserva confirmada → RESERVADO
Inicio de alquiler → ALQUILADO
Mantenimiento programado → EN_MANTENIMIENTO
Devolución → DISPONIBLE
Historial: La clase HistorialVehiculo registra todos los cambios de estado del vehículo.
3.3 Reservas de Vehículos
Actores: Cliente (a través de Administrativo o sistema web)
Operaciones:
Crear reserva:


Cliente selecciona vehículo disponible
Define fechas de inicio y fin
Sistema calcula costo estimado
Estado inicial: PENDIENTE
Confirmar reserva:


Administrativo valida disponibilidad
Vehículo pasa a estado RESERVADO
Se bloquea para otros clientes
Cancelar reserva:


Cliente o administrativo cancela
Vehículo vuelve a DISPONIBLE
Convertir a alquiler:


Al momento del retiro, la reserva se convierte en Alquiler
Se genera Contrato y Factura
Validaciones:
Disponibilidad del vehículo en fechas solicitadas
Licencia de conducir vigente del cliente
No puede haber reservas superpuestas para el mismo vehículo
3.4 Contratos de Alquiler
Actores: Administrativo (genera), Cliente (firma)
Proceso:
Generación automática: Al iniciar un alquiler, el sistema crea un Contrato
Datos incluidos:
- Cliente (datos personales, licencia)
- Vehículo (marca, modelo, patente)
- Fechas: inicio y devolución prevista
- Kilometraje inicial
- Nivel de combustible inicial
- Costo estimado
- Términos y condiciones de la empresa
- Firma digital del cliente
Entrega: Se imprime o envía por email al cliente
Estado: VIGENTE, FINALIZADO, CANCELADO
3.5 Pagos y Facturación
Actores: Administrativo, Cliente
Flujo completo:
Generación de Factura:


Al confirmar el alquiler, se crea Factura en estado PENDIENTE
Se agregan líneas de DetalleFactura:
Alquiler base: días × precioDiario
Extras opcionales: seguro, GPS, silla bebé
Se calcula subtotal e impuestos (IVA)
Total = subtotal + impuestos
Registro de Pago:


Administrativo procesa el pago
Selecciona método: EFECTIVO, TARJETA_CREDITO, etc.
Registra monto, número de transacción
Si monto = total factura → estado PAGADA
Si monto < total → permite pagos parciales
Cargos Adicionales:


Durante o al finalizar el alquiler, pueden generarse CargoAdicional en el Alquiler
Cada cargo se agrega como nueva línea de DetalleFactura a la Factura
Factura se recalcula automáticamente usando recalcularTotales()
Si ya estaba pagada, pasa a PENDIENTE por saldo
Emisión:


Factura impresa o enviada por email
Formato PDF con logo de empresa
Identificación única por idFactura
Reportes financieros: Los gerentes pueden consultar ingresos por período o categoría de vehículo.
3.6 Control de Devoluciones
Actores: Administrativo, Técnico
Proceso detallado:
Recepción del vehículo:


Cliente devuelve vehículo
Administrativo usa el método alquiler.registrarDevolucion(...) para registrar:
- Fecha y hora real de devolución
- Kilometraje final
- Nivel de combustible final
- Estado del vehículo
- Observaciones
Inspección:


Verificación de kilometraje: Comparar con inicial
Nivel de combustible: Medir nivel actual vs inicial
Estado general: Inspección visual de daños
Limpieza: Evaluar si requiere limpieza profunda
Técnico puede realizar inspección técnica más detallada
Cálculo de cargos adicionales automático (usando alquiler.calcularCargosAdicionales()):

 a) Devolución tardía:

 Si fechaDevolucionReal > fechaDevolucionPrevista:
  diasExtras = diferencia en días
  cargo = diasExtras × tarifaDevolucionTardiaPorDia
  Crear CargoAdicional tipo DEVOLUCION_TARDIA
 b) Kilometraje extra:

 Si incluido = 100 km/día:
  kmIncluidos = días × 100
  kmRecorridos = kilometrajeFinal - kilometrajeInicial
  Si kmRecorridos > kmIncluidos:
    kmExtras = kmRecorridos - kmIncluidos
    cargo = kmExtras × tarifaKilometrajeExtraPorKm
    Crear CargoAdicional tipo KILOMETRAJE_EXTRA
 c) Combustible:

 Si politica = LLENO_A_LLENO:
  litrosFaltantes = capacidadTanque - nivelCombustibleActual
  Si litrosFaltantes > 0:
    cargo = litrosFaltantes × tarifaCombustiblePorLitro
    Crear CargoAdicional tipo COMBUSTIBLE
 d) Daños:

 Si se detectan daños:
  Técnico estima costo de reparación
  Crear CargoAdicional tipo DANO_VEHICULO
 e) Limpieza:

 Si vehículo requiere limpieza profunda:
  cargo = tarifaLimpieza (fijo)
  Crear CargoAdicional tipo LIMPIEZA


Actualización de Factura:


Cada CargoAdicional generado se agrega al Alquiler usando alquiler.agregarCargo(...)
Cada cargo se convierte en una línea de DetalleFactura en la Factura asociada
La Factura se recalcula automáticamente usando factura.recalcularTotales()
Si hay saldo pendiente, se notifica al cliente
Finalización:


Alquiler pasa a estado FINALIZADO
Contrato pasa a estado FINALIZADO
Vehículo pasa a estado DISPONIBLE (o EN_LIMPIEZA/EN_INSPECCION según corresponda)
3.7 Mantenimiento de Vehículos
Actores: Técnico (ejecuta), Gerente (aprueba)
Tipos de mantenimiento:
Preventivo (programado):
Cambio de aceite (cada 10,000 km)
Rotación de neumáticos (cada 15,000 km)
Revisión general (cada 6 meses)
Sistema genera alertas automáticas
Correctivo (por falla):
Reparación de averías detectadas
Reemplazo de piezas dañadas
Revisión (inspección):
Verificación técnica vehicular (VTV)
Inspección post-devolución
Reparación (por daño en alquiler):
Arreglo de daños reportados en devolución
Costo se cobra al cliente como CargoAdicional
Flujo:
Programación:


Técnico o sistema crea registro de Mantenimiento
Estado: PROGRAMADO
Vehículo cambia a estado EN_MANTENIMIENTO
Sistema bloquea vehículo para nuevas reservas
Aprobación gerencial:


Si costo estimado > umbral definido ($500):
Gerente revisa y aprueba mantenimiento
Sistema notifica a técnico
Si costo < umbral:
Aprobación automática
Ejecución:


Técnico inicia trabajo
Estado: EN_PROCESO
Registra trabajos realizados, repuestos utilizados
Costo total
Finalización:


Técnico completa mantenimiento
Estado: COMPLETADO
Registra costo total
Vehículo pasa a EN_INSPECCION
Habilitación:


Técnico inspecciona y habilita vehículo
Vehículo vuelve a DISPONIBLE
Historial: Todos los mantenimientos quedan registrados en el historial del vehículo, permitiendo:
Consultar próximo mantenimiento programado
Ver costos históricos de mantenimiento
Decidir cuándo dar de baja un vehículo por costos excesivos
3.8 Reportes y Estadísticas
Actores: Gerente (genera y analiza)
Reportes disponibles:
DISPONIBILIDAD_VEHICULOS:


Lista de vehículos por categoría
Estado actual de cada vehículo
Tasa de ocupación por categoría
Vehículos en mantenimiento o reparación
CONTRATOS_ACTIVOS:


Alquileres en curso
Fechas de devolución previstas
Clientes actuales
Ingresos proyectados
INGRESOS_ALQUILER:


Facturación por período (diario, semanal, mensual, anual)
Desglose por:
Categoría de vehículo
Tipo de ingreso (alquiler base vs cargos adicionales)
Comparativas entre períodos
Gráficos de tendencias
MANTENIMIENTOS:


Mantenimientos realizados por período
Costos de mantenimiento por vehículo
Vehículos con mayor frecuencia de reparaciones
Análisis de rentabilidad (ingresos vs costos de mantenimiento)
CLIENTES_FRECUENTES:


Clientes con más alquileres
Preferencias de categorías
Valor de vida del cliente (lifetime value)
Tasa de retención
Funcionalidades:
Filtros por fecha, categoría, empleado
Exportación a PDF y Excel
Gráficos y visualizaciones
Envío automático por email
Casos de uso gerenciales:
Identificar categorías más/menos rentables
Decidir compra de nuevos vehículos (qué categorías tienen más demanda)
Planificar mantenimientos (períodos de baja demanda)
Ajustar tarifas según ocupación
Evaluar desempeño de empleados
3.9 Seguridad y Autenticación
Implementación:
Sistema de Login
Clase Usuario: Credenciales de acceso
Clase Sesion: Gestiona sesiones activas
Proceso:
Usuario ingresa username y password
Sistema valida credenciales
Si son correctas:
Crea registro de Sesion
Registra fecha y hora de inicio
Carga permisos según rol
Durante la sesión, cada acción es validada contra permisos
Control de Acceso por Roles
RolUsuarioEnum define jerarquía de permisos:
CLIENTE:


Ver sus propias reservas y alquileres
Crear nuevas reservas
Cancelar reservas propias
Consultar facturas propias
Actualizar datos personales
TECNICO:


Permisos de CLIENTE +
Inspeccionar vehículos
Crear y gestionar mantenimientos
Cambiar estado de vehículos (DISPONIBLE ↔ EN_MANTENIMIENTO)
Consultar historial de mantenimientos
ADMINISTRATIVO:


Permisos de CLIENTE +
Gestionar reservas de cualquier cliente
Iniciar y finalizar alquileres
Generar contratos y facturas
Registrar pagos y devoluciones
Aplicar cargos adicionales
Registrar nuevos clientes
Consultar disponibilidad de vehículos
GERENTE:


Todos los permisos anteriores +
Gestionar empleados (contratar, despedir, cambiar turnos)
Aprobar descuentos especiales
Aprobar mantenimientos costosos
Gestionar flota (alta/baja vehículos)
Generar todos los tipos de reportes
Modificar configuraciones de empresa
Resolver reclamaciones
ADMIN (implícito en sistema):


Control total del sistema
Gestión de empresa
Configuración de parámetros globales
Acceso a auditorías completas
Auditoría y Trazabilidad
Clase RegistroAuditoria: Registra cada operación sensible
Información capturada:
Qué se hizo (TipoOperacionEnum)
Quién lo hizo (Usuario responsable)
Cuándo (fecha y hora exacta)
Sobre qué entidad (Vehiculo, Cliente, Factura, etc.)
Detalles del cambio
Eventos auditados:
Altas, bajas y modificaciones de usuarios
Cambios en vehículos
Generación y anulación de facturas
Aplicación de descuentos
Devoluciones con cargos adicionales
Accesos al sistema (intentos fallidos de login)
Seguridad Adicional:
Passwords encriptados (nunca en texto plano)
Sesiones con timeout automático
Bloqueo de cuenta tras intentos fallidos
Recuperación de contraseña con validación de email
Logs de acceso por IP y dispositivo

4. FLUJOS DE TRABAJO COMPLETOS
4.1 Flujo: Cliente alquila un vehículo
Escenario: Juan Pérez quiere alquilar una camioneta por 5 días
Registro (si es cliente nuevo):


Administrativo crea Cliente en sistema
Valida licencia de conducir vigente
Crea Usuario asociado con rol CLIENTE
Estado: ACTIVO
Reserva (opcional):


Juan busca disponibilidad
Selecciona Camioneta categoría SUV
Fechas: 15/11/2025 - 20/11/2025
Sistema calcula costo: 5 días × $80/día = $400
Se crea Reserva estado PENDIENTE
Administrativo confirma → estado CONFIRMADA
Vehículo pasa a RESERVADO
Retiro del vehículo (15/11/2025):


Juan llega
Administrativo convierte Reserva en Alquiler
Se crea instancia de Alquiler con cliente y vehículo
Se genera Contrato asociado (relación 1:1):
Fecha inicio: 15/11/2025
Fecha devolución prevista: 20/11/2025
Kilometraje inicial: 45,230 km
Combustible inicial: tanque lleno
Costo estimado: $400
Firma cliente
Estado: VIGENTE
Se genera Factura asociada al Alquiler (relación 1:1):
DetalleFactura #1: "Alquiler Camioneta SUV (5 días)" - $400
DetalleFactura #2: "Seguro premium" - $50
Subtotal: $450
IVA 21%: $94.50
Total: $544.50
Juan paga con tarjeta:
Se crea Pago método TARJETA_CREDITO
Monto: $544.50
Factura pasa a PAGADA
Firmas digitales en contrato
Vehículo cambia a ALQUILADO
Juan se retira con el vehículo
Durante el alquiler:


Juan maneja 650 km
No hay incidentes
Devolución (21/11/2025 - un día tarde):


Juan devuelve vehículo
Administrativo registra la devolución usando:
alquiler.registrarDevolucion(fechaReal, 45880, 0.8, "BUENO", "Sin daños, limpio")
Datos registrados:
- Fecha real: 21/11/2025 (1 día tarde)
- Kilometraje final: 45,880 km (650 km recorridos)
- Combustible: 80% del tanque
- Estado: BUENO
- Observaciones: "Sin daños, limpio"
Sistema ejecuta alquiler.calcularCargosAdicionales() que genera automáticamente:

 a) Devolución tardía:


1 día × $100 = $100
Se crea CargoAdicional tipo DEVOLUCION_TARDIA
Se agrega al alquiler: alquiler.agregarCargo(cargo)
b) Kilometraje:


Incluidos: 5 días × 100 km = 500 km
Recorridos: 650 km
Extra: 150 km × $0.20 = $30
Se crea CargoAdicional tipo KILOMETRAJE_EXTRA
Se agrega al alquiler: alquiler.agregarCargo(cargo)
c) Combustible:


Tanque 50 litros, devuelto al 80% = 40 litros
Faltantes: 10 litros × $1.50 = $15
Se crea CargoAdicional tipo COMBUSTIBLE
Se agrega al alquiler: alquiler.agregarCargo(cargo)
Actualización de factura:


Los cargos del alquiler se agregan a la factura como DetalleFactura:
DetalleFactura #3: "Cargo devolución tardía (1 día)" - $100
DetalleFactura #4: "Cargo kilometraje extra (150 km)" - $30
DetalleFactura #5: "Cargo combustible (10 litros)" - $15
Se ejecuta factura.recalcularTotales():
Nuevo subtotal: $595
IVA 21%: $124.95
Nuevo total: $719.95
Factura vuelve a PENDIENTE
Saldo adeudado: $719.95 - $544.50 = $175.45
Pago del saldo:


Administrativo procesa pago adicional
Juan paga $175.45 en efectivo
Se crea nuevo Pago
Factura pasa a PAGADA
Finalización:


alquiler.setEstadoAlquiler(EstadoAlquilerEnum.FINALIZADO)
contrato.setEstado("FINALIZADO")
vehiculo.setEstado(EstadoVehiculoEnum.DISPONIBLE)
Se envía factura final por email
Resultado: Sistema registró completo el ciclo en el objeto Alquiler, calculó automáticamente cargos adicionales, mantuvo trazabilidad completa.
4.2 Flujo: Mantenimiento programado de vehículo
Escenario: Auto Patente ABC123 alcanzó 50,000 km y requiere servicio
Detección:


Sistema monitorea kilometraje en cada devolución
Al registrar devolución, detecta que vehículo alcanzó umbral
Genera alerta para técnico: "Servicio 50,000 km requerido"
Programación:


Técnico crea registro Mantenimiento:
Tipo: PREVENTIVO
Descripción: "Servicio 50,000 km - cambio aceite, filtros, rotación neumáticos"
Fecha programada: próximo día sin reservas
Estado: PROGRAMADO
Vehículo cambia a EN_MANTENIMIENTO
Sistema bloquea vehículo para nuevas reservas
Aprobación gerencial:


Si costo estimado > umbral definido ($500):
Gerente revisa y aprueba mantenimiento
Sistema notifica a técnico
Si costo < umbral:
Aprobación automática
Ejecución:


Técnico inicia trabajo (22/11/2025 08:00)
Estado: EN_PROCESO
Trabajos realizados:
Cambio de aceite y filtro
Reemplazo filtro de aire
Rotación de neumáticos
Revisión de frenos
Verificación de luces
Revisión de niveles
Técnico registra repuestos utilizados:
Aceite sintético 5W-30: 4 litros
Filtro de aceite: 1 unidad
Filtro de aire: 1 unidad
Costo total: $380
Finalización:


Técnico completa mantenimiento (22/11/2025 14:00)
Actualiza registro:
Fecha fin real: 22/11/2025 14:00
Trabajos realizados: (descripción detallada)
Costo final: $380
Estado: COMPLETADO
Vehículo pasa a EN_INSPECCION
Inspección post-mantenimiento:


Técnico realiza prueba de ruta
Verifica que todo funcione correctamente
Crea InformeInspeccion:
Resultado: "Vehículo en óptimas condiciones"
Próximo mantenimiento: 60,000 km
Sin problemas detectados
Habilitación:


Técnico habilita vehículo
Vehículo cambia a DISPONIBLE
Sistema registra en HistorialVehiculo:
"22/11/2025: EN_MANTENIMIENTO → DISPONIBLE"
"Mantenimiento preventivo 50,000 km completado"
Registro histórico:


Información queda en historial del vehículo
Permite consultar:
Último mantenimiento: 22/11/2025
Próximo mantenimiento: 60,000 km
Costo acumulado mantenimientos: $X
Tiempo fuera de servicio: 6 horas
Resultado: Vehículo mantenido correctamente, historial actualizado, disponible para nuevos alquileres.
4.3 Flujo: Reporte de ingresos mensuales
Escenario: Gerente necesita analizar rendimiento de noviembre 2025
Solicitud:


Gerente ingresa al módulo de reportes
Selecciona: TipoReporteEnum.INGRESOS_ALQUILER
Parámetros:
Fecha inicio: 01/11/2025
Fecha fin: 30/11/2025
Formato: PDF + Excel
Generación automática: Sistema consulta base de datos y calcula:

 A. Ingresos por alquiler base:

 SELECT SUM(df.subtotal)
FROM DetalleFactura df
JOIN Factura f ON df.factura = f.id
WHERE df.concepto LIKE '%Alquiler%'
AND f.estado = 'PAGADA'
AND f.fechaEmision BETWEEN '2025-11-01' AND '2025-11-30'
 Resultado: $45,600

 B. Ingresos por servicios adicionales:


Seguros: $3,200
GPS: $1,500
Sillas bebé: $450
Total extras: $5,150
C. Ingresos por cargos adicionales:


Devoluciones tardías: $2,800
Kilometraje extra: $1,200
Combustible: $850
Daños: $1,500
Limpieza: $300
Total cargos: $6,650
D. Total bruto: $57,400

 E. Desglose por categoría:


ECONOMICO: $12,500 (22%)
SEDAN: $15,800 (28%)
SUV: $18,200 (32%)
CAMIONETA: $8,900 (15%)
MOTO: $2,000 (3%)
G. Métricas adicionales:


Cantidad de alquileres: 142
Duración promedio: 4.2 días
Ingreso promedio por alquiler: $404
Tasa de ocupación: 68%
Cargos adicionales sobre total: 11.6%
Análisis comparativo: Sistema compara con mes anterior (octubre 2025):


Variación ingresos: +12.5%
Variación cantidad alquileres: +8.3%
Variación ticket promedio: +3.9%
Identificación de tendencias:


Categoría más rentable: SUV
Día de semana con más alquileres: Viernes
Cargos adicionales más frecuentes: Devolución tardía
Generación de gráficos:


Gráfico de barras: Ingresos por categoría
Gráfico de líneas: Evolución diaria de ingresos
Gráfico de torta: Distribución por categoría
Gráfico de barras apiladas: Alquiler base vs extras vs cargos
Exportación:


PDF ejecutivo con resumen y gráficos
Excel con datos detallados y tablas dinámicas
Se envía por email al gerente
Acciones gerenciales: Basado en el reporte, gerente decide:


Aumentar flota de SUVs (alta demanda)
Implementar campaña anti-devoluciones tardías
Ajustar tarifas de categoría MOTO (baja demanda)
Resultado: Información estratégica para toma de decisiones, visión clara del negocio.
4.4 Flujo: Accidente Durante Alquiler
Escenario: Cliente tiene accidente con vehículo alquilado
Proceso:
Notificación inmediata:


Cliente debe reportar en máximo 24 horas
Llama a línea de emergencia empresa
Proporciona:
Datos del accidente
Ubicación
Si hay heridos
Daños visibles
Registro en sistema:


Administrativo crea registro de Incidente:
Fecha: 26/11/2025 10:30
Alquiler: #1234
Cliente: Juan Pérez
Vehículo: SUV ABC123
Descripción: Colisión lateral en intersección
Gravedad: MODERADA
Hay denuncia policial: SÍ
Número denuncia: 98765

Evaluación inicial:


Si vehículo no puede circular:
Se envía grúa
Cliente recibe vehículo de reemplazo (según contrato de seguro)
Si puede circular:
Cliente lo lleva a taller autorizado
Inspección técnica:


Técnico evalúa daños:
Daños estructurales: No
Daños mecánicos: No
Daños estéticos: Sí
- Puerta delantera derecha: abolladura
- Guardabarro derecho: rayones
Estimación reparación: $1,200

Gestión del seguro:


Si cliente contrató seguro premium:
Cobertura total, sin deducible
Empresa factura a aseguradora
Si cliente contrató seguro básico:
Deducible: $300
Se genera CargoAdicional
Si NO contrató seguro:
Cliente paga totalidad: $1,200
Se genera CargoAdicional
Reparación:


Vehículo pasa a EN_REPARACION
Se crea Mantenimiento tipo REPARACION
Técnico coordina con taller
Seguimiento de reparación
Finalización:


Vehículo reparado
Técnico inspecciona y aprueba
Se actualiza Factura con cargos
Cliente paga deducible/total según corresponda
Alquiler finaliza
Vehículo vuelve a DISPONIBLE
Análisis posterior:


Se analiza causa
Si fue negligencia del cliente:
Se registra en historial
Puede afectar futuros alquileres
Si fue falla mecánica:
Se investiga mantenimiento
Posible responsabilidad de empresa
Prevención:
Inspección obligatoria pre-alquiler
Fotos del vehículo al entregar
Contrato explicita responsabilidades
Seguro recomendado pero no obligatorio

5. REGLAS DE NEGOCIO IMPLEMENTADAS
5.1 Reglas de Reservas
No superposición: Un vehículo no puede tener reservas superpuestas en fechas
Anticipación mínima: Reservas deben hacerse con al menos 2 horas de anticipación
Duración mínima: Alquiler mínimo de 1 día
Duración máxima reserva: Reserva sin confirmar expira en 24 horas
Cancelación: Cliente puede cancelar hasta 24 horas antes sin penalidad
5.2 Reglas de Alquiler
Requisitos del cliente:


Edad mínima: 21 años (25 para categorías LUJO y DEPORTIVO)
Licencia vigente con antigüedad mínima 2 años
Documento de identidad válido
Tarjeta de crédito para garantía
Depósito de seguridad:


ECONOMICO/COMPACTO: $500
SEDAN/SUV: $800
CAMIONETA: $1,000
LUJO/DEPORTIVO: $2,000
MOTO: $300
Kilometraje incluido: 100 km/día (política modificable por empresa)


Combustible: Política LLENO_A_LLENO (devolver con tanque lleno)


Conductor adicional: $10/día extra por conductor


5.3 Reglas de Devolución
Tolerancia: 1 hora de gracia sin cargo
Devolución tardía:
Hasta 2 horas: $25
Más de 2 horas: se cobra día completo adicional
Kilometraje extra: $0.20 por km excedente
Combustible faltante: $1.50 por litro (precio superior al mercado)
Inspección obligatoria: Todo vehículo debe ser inspeccionado al devolver
5.4 Reglas de Facturación
IVA: 21% sobre todos los servicios (configurable por país)
Factura obligatoria: Toda operación genera factura fiscal
Método de pago:
Efectivo: hasta $10,000
Tarjeta: sin límite
Transferencia: para empresas con cuenta corporativa
Pagos parciales: Permitidos, mínimo 50% al inicio
Anulación: Solo gerente puede anular facturas, con auditoría
5.5 Reglas de Mantenimiento
Preventivo obligatorio:


Cada 10,000 km: Cambio de aceite
Cada 20,000 km: Servicio completo
Cada 6 meses: Revisión general (lo que ocurra primero)
Post-alquiler:


Inspección técnica cada 5 alquileres
Limpieza profunda cada 10 alquileres
Prioridad: Vehículos en reparación tienen prioridad sobre preventivos


Vehículo no disponible: Durante mantenimiento, vehículo bloqueado para alquiler


5.6 Reglas de Seguridad
Sesión: Timeout de 30 minutos de inactividad
Password:
Mínimo 8 caracteres
Al menos 1 mayúscula, 1 minúscula, 1 número
Cambio obligatorio cada 90 días
Intentos de login: Máximo 3 intentos, luego bloqueo temporal
Auditoría: Operaciones críticas siempre registradas con usuario responsable

6. VALIDACIONES DEL SISTEMA
6.1 Validaciones de Datos
Cliente:
Email: formato válido y único
Licencia conducir: no vencida, tipo adecuado para categoría
Edad: mínima según categoría de vehículo
Teléfono: formato válido
Vehículo:
Patente: formato válido, única en el sistema
Año: no puede ser futuro, no menor a 2000
Kilometraje: no puede decrecer (salvo error corregible por gerente)
Precio diario: mayor a 0
Capacidad tanque: mayor a 0
Reserva/Alquiler:
Fecha inicio: no puede ser pasada
Fecha fin: debe ser posterior a fecha inicio
Vehículo: debe estar disponible en esas fechas
Cliente: debe tener licencia válida
Factura:
Total: debe ser mayor a 0
Número: único, secuencial
DetalleFactura: debe tener al menos 1 línea
Pago:
Monto: mayor a 0, no puede exceder saldo factura
Método: debe ser válido y aceptado por empresa
6.2 Validaciones de Negocio
Al crear reserva:
validarReserva(reserva) {
  // Vehículo debe estar disponible
  if (vehiculo.estado != DISPONIBLE)
    throw "Vehículo no disponible";

  // No debe haber reservas superpuestas
  if (existeReservaEnFechas(vehiculo, fechas))
    throw "Vehículo ya reservado en esas fechas";

  // Cliente debe tener licencia válida
  if (cliente.licenciaVencimiento < fechaInicio)
    throw "Licencia de conducir vencida";

  // Duración mínima
  if (duracionDias < 1)
    throw "Duración mínima: 1 día";
}

Al iniciar alquiler:
validarInicioAlquiler(alquiler) {
  // Vehículo debe estar disponible o reservado
  if (vehiculo.estado != DISPONIBLE && vehiculo.estado != RESERVADO)
    throw "Vehículo no disponible para alquiler";

  // Cliente debe cumplir edad mínima
  if (cliente.edad < edadMinimaPorCategoria[vehiculo.categoria])
    throw "Edad insuficiente para esta categoría";

  // Debe haber pago o garantía
  if (!tienePagoInicial && !tieneGarantia)
    throw "Debe proporcionar pago o garantía";
}

Al devolver vehículo:
validarDevolucion(alquiler, kilometrajeFinal) {
  // Alquiler debe estar activo
  if (alquiler.estado != ACTIVO)
    throw "Alquiler no está activo";

  // Kilometraje no puede ser menor al inicial
  if (kilometrajeFinal < alquiler.kilometrajeInicial)
    throw "Kilometraje inválido";
    
  // No debe tener ya una devolución registrada
  if (alquiler.tieneDevolucion())
    throw "Este alquiler ya tiene una devolución registrada";
}

Al programar mantenimiento:
validarMantenimiento(mantenimiento) {
  // Vehículo no debe estar alquilado
  if (vehiculo.estado == ALQUILADO)
    throw "No se puede programar mantenimiento en vehículo alquilado";

  // Debe haber técnico disponible
  if (!hayTecnicoDisponible(fechaProgramada))
    throw "No hay técnicos disponibles en esa fecha";

  // Costo debe ser razonable
  if (costo > vehiculo.valorMercado * 0.3)
    alert "Costo muy alto, requiere aprobación gerente";
}

7. GLOSARIO DE TÉRMINOS
Alquiler: Operación comercial donde un cliente renta un vehículo por un período determinado. Contiene toda la información del proceso incluyendo datos de devolución cuando esta se registra.
Cargo Adicional: Monto extra cobrado por conceptos no incluidos en el alquiler base (tardías, daños, etc.). Se asocia al Alquiler y genera líneas en la Factura.
Contrato: Documento legal que establece términos y condiciones del alquiler. Tiene relación 1:1 con Alquiler.
Devolución: Proceso de retorno del vehículo gestionado dentro de la clase Alquiler mediante los atributos fechaDevolucionReal, kilometrajeFinal, nivelCombustibleFinal, estadoVehiculo y observaciones.
Factura: Documento fiscal que detalla los conceptos y montos a pagar. Tiene relación 1:1 con Alquiler y contiene múltiples DetalleFactura.
Flota: Conjunto de vehículos gestionados por la empresa
Mantenimiento Preventivo: Servicio programado para prevenir fallas
Mantenimiento Correctivo: Reparación de fallas ya ocurridas
Reserva: Compromiso anticipado de alquiler de un vehículo
Tasa de Ocupación: Porcentaje de tiempo que los vehículos están alquilados vs disponibles


