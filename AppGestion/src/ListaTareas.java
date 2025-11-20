/**
 * ----- Mensaje genérico -----
 * Clase administrada sólo por RICARDO.
 * Puede modificarse por alguien más SÓLO en caso de que quiera hacer pruebas, pero debe
 * regresarse a su estado original. En caso de que no se reestablezca a su estado original,
 * el pull request será rechazado.
 * ----- Mensaje genérico -----
 * 
 * ----- Mensaje para VISITANTES -----
 * 
 * ----- Mensaje para VISITANTES -----
 * 
 * INSERTA TU PROPIO COMENTARIO DE LA CLASE.
 */

import java.io.Serializable;
import java.time.LocalDate;

public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
//Identificador unico de las tareas
    private int id;
  //Estado actual de la tarea
    private EstadoTarea estado;
  
    private int idUsuarioAsignado;
  //Descripcion de la tarea
    private String descripcion;

    private LocalDate fechaEstimadaInicio;
    private LocalDate fechaInicio;           // Se fija al pasar a EN_CURSO
    private LocalDate fechaEstimadaFin;
    private LocalDate fechaFin;              // Se fija al pasar a COMPLETADA


    public Tarea(int id, int idUsuarioAsignado, String descripcion,
                 LocalDate fechaEstimadaInicio, LocalDate fechaEstimadaFin) {
        this.id = id;
        this.idUsuarioAsignado = idUsuarioAsignado;
        this.descripcion = descripcion;
        this.fechaEstimadaInicio = fechaEstimadaInicio;
        this.fechaEstimadaFin = fechaEstimadaFin;
        this.estado = EstadoTarea.PENDIENTE;
    }

    public int getId() {
        return id;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public int getIdUsuarioAsignado() {
        return idUsuarioAsignado;
    }

    public void setIdUsuarioAsignado(int idUsuarioAsignado) {
        this.idUsuarioAsignado = idUsuarioAsignado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaEstimadaInicio() {
        return fechaEstimadaInicio;
    }

    public void setFechaEstimadaInicio(LocalDate fechaEstimadaInicio) {
        this.fechaEstimadaInicio = fechaEstimadaInicio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaEstimadaFin() {
        return fechaEstimadaFin;
    }

    public void setFechaEstimadaFin(LocalDate fechaEstimadaFin) {
        this.fechaEstimadaFin = fechaEstimadaFin;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Tarea ID: " + id +
               "\n  Estado: " + estado +
               "\n  Usuario asignado (ID): " + idUsuarioAsignado +
               "\n  Descripción: " + descripcion +
               "\n  Fecha estimada inicio: " + fechaEstimadaInicio +
               "\n  Fecha inicio: " + fechaInicio +
               "\n  Fecha estimada fin: " + fechaEstimadaFin +
               "\n  Fecha fin: " + fechaFin;
    }
}
