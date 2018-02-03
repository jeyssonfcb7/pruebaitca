/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javabeans.Computadora;
import javabeans.Contacto;
import javabeans.Web;

/**
 *
 * @author paul
 */
public class UtilidadesHTML {
    public String generarTablaHtmlContactos(ArrayList listaContactos) {
        String html = "<table border=1>";
        html += "<tr><th>Id</th><th>Nombre</th><th>Apellido1</th><th>Apellido2</th>"
                + "<th>Direcci&oacute;n</th><th>Tel&eacute;fono</th><th>Celular</th>"
                + "<th>Email</th></tr>";
        for (Object objContacto : listaContactos) {
            Contacto contacto = (Contacto) objContacto;
            html += "<tr>";
            html += "<td>" + contacto.getId() + "</td>";
            html += "<td>" + contacto.getNombre() + "</td>";
            html += "<td>" + contacto.getApellido1() + "</td>";
            html += "<td>" + contacto.getApellido2() + "</td>";
            html += "<td>" + contacto.getDireccion() + "</td>";
            html += "<td>" + contacto.getTelefono() + "</td>";
            html += "<td>" + contacto.getCelular() + "</td>";
            html += "<td>" + contacto.getEmail() + "</td>";
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }

	 public String generarTablaHtmlWeb(ArrayList listaWebs) {
        String html = "<table border='1'>";
        html += "<tr>"
					 + "<th>Id</th>"
					 + "<th>Fecha Inserci&oacute;</th>"
					 + "<th>Direcci&oacute;n</th>"
					 + "<th>Nombre WebSite</th>"
                + "<th>Categor&iacute;a</th>"
					 + "<th>SubCategor&iacute;a</th>"
					 + "<th>Puntuacion</th>"
                + "<th>Idioma</th>"
				+ "</tr>";
        for (Object objWeb : listaWebs) {
            Web webs = (Web) objWeb;
            html += "<tr>";
            html += "<td>" + webs.getId() + "</td>";
            html += "<td>" + webs.getFecha_inserccion()+ "</td>";
            html += "<td>" + webs.getDireccion_website() + "</td>";
            html += "<td>" + webs.getNombre_website() + "</td>";
            html += "<td>" + webs.getCategoria() + "</td>";
            html += "<td>" + webs.getSubcategoria() + "</td>";
            html += "<td>" + webs.getPuntuacion() + "</td>";
            html += "<td>" + webs.getIdioma() + "</td>";
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }

	 public String generarTablaHtml(ArrayList listaPcs) {
        String html = "<table border='1'>";
        html += "<tr>"
                + "<th>ID</th>"
                + "<th>Marca</th>"
                + "<th>Procesador</th>"
                + "<th>Memoria</th>"
                + "<th>Disco</th>"
                + "<th>Memoria de Video</th>"
                + "<th>Descripci&oacute;n</th>"
            + "</tr>";
        for (Object objWeb : listaPcs) {
            Computadora pc = (Computadora) objWeb;
            html += "<tr>";
            html += "<td>" + pc.getId() + "</td>";
            html += "<td>" + pc.getMarca() + "</td>";
            html += "<td>" + pc.getProcesador() + "</td>";
            html += "<td>" + pc.getMemoria() + " GB</td>";
            html += "<td>" + pc.getDisco() + "</td>";
            html += "<td>" + pc.getMemoria_video() + " GB</td>";
            html += "<td>" + pc.getDescripcion() + "</td>";
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }
}
