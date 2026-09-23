# Examen T1 - DESARROLLO DE APLICACIONES MOVILES I

Este proyecto implementa **seis ejercicios** en Kotlin.

---

## Pregunta 1: Salida tardía (Late Check-out) en hotel
- **Regla:** Hasta 2 horas después del check-out estándar (12:00 m.) sin costo.
- **Cargo:**
    - ≤ 2 horas → "Salida dentro del margen de cortesía del hotel."
    - > 2 horas → `S/ 60.00 + S/ 25.00 * (horas - 2)`

**Requerimientos:**
1. Ingresar horas adicionales (numérico).
2. Mostrar mensaje según condición.
3. Si aplica cobro: mostrar horas solicitadas, horas sujetas a cobro y cargo total.
4. Formato moneda: `S/ 0.00`.

---

## Pregunta 2: Exceso de peso en mascotas para cabina de avión
- **Regla:** Peso total permitido ≤ 8 kg.
- **Cargo:**
    - ≤ 8 kg → "Mascota apta para viajar en cabina sin sobrecosto."
    - > 8 kg → `S/ 150.00 + S/ 35.00 * (peso - 8)`

**Requerimientos:**
1. Ingresar peso total (numérico con decimales).
2. Mostrar mensaje según condición.
3. Si aplica recargo: mostrar peso total, exceso y monto total.
4. Formato moneda: `S/ 0.00`.

---

## Pregunta 3: Desperdicio de comida en restaurante tipo buffet
- **Regla:** Tolerancia hasta 100 g de comida sobrante.
- **Cargo:**
    - ≤ 100 g → "Plato dentro del margen admisible de consumo."
    - > 100 g → `S/ 15.00 + S/ 0.12 * (gramos - 100)`

**Requerimientos:**
1. Ingresar gramos sobrantes (numérico).
2. Mostrar mensaje según condición.
3. Si aplica penalización: mostrar gramos sobrantes, exceso y penalización total.
4. Formato moneda: `S/ 0.00`.

---

## Pregunta 4: Alquiler de canchas sintéticas de fútbol
- **Regla:** Hasta 10 minutos de tolerancia sin costo.
- **Cargo:**
    - ≤ 10 min → "Tiempo de tolerancia para desalojo y cambio de turno."
    - > 10 min → `S/ 30.00 + S/ 2.50 * (minutos - 10)`

**Requerimientos:**
1. Ingresar minutos adicionales (numérico entero).
2. Mostrar mensaje según condición.
3. Si aplica cobro: mostrar minutos usados, minutos computables y monto adicional.
4. Formato moneda: `S/ 0.00`.

---

## Pregunta 5: Consumo de energía en eventos de ferias y stands
- **Regla:** Potencia base incluida = 1,000 W.
- **Cargo:**
    - ≤ 1,000 W → "Consumo eléctrico dentro de la capacidad asignada."
    - > 1,000 W → `S/ 180.00 + S/ 0.40 * (watts - 1000)`

**Requerimientos:**
1. Ingresar potencia consumida (numérico).
2. Mostrar mensaje según condición.
3. Si aplica recargo: mostrar potencia registrada, sobrecarga y cobro total.
4. Formato moneda: `S/ 0.00`.

---

## Pregunta 6: Días de estancia en clínica veterinaria
- **Regla:** Paquete básico cubre hasta 3 días.
- **Cargo:**
    - ≤ 3 días → "Días cubiertos por el paquete quirúrgico contratado."
    - > 3 días → `S/ 95.00 + S/ 45.00 * (días - 3)`

**Requerimientos:**
1. Ingresar días internado (numérico entero).
2. Mostrar mensaje según condición.
3. Si aplica cobro: mostrar días registrados, días excedentes y costo adicional.
4. Formato moneda: `S/ 0.00`.

