/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package umsa.capricornio.domain;

/**
 *
 * @author julian
 */
public class ProveedoresData { 
    
    public String  cod_proveedor;
    public String  cod_estado;
    public String  fax;
    public String  web;
    public String  gran_act;
    public String  razon_nit;
    public String  partida;
    public String  casa_comercial;
    public String  servicio;
    public String  direccion;
    public String  telefono;
    public String  nit;
    public String  estado;
    
    
    public ProveedoresData(String cod_proveedor, String cod_estado,String web,String gran_act,String razon_nit,String partida,String casa_comercial,String servicio,String direccion,String telefono,String fax,String nit,String estado) {
        this.cod_proveedor=cod_proveedor;
        this.cod_estado=cod_estado;
        this.fax=fax;
        this.web=web;
        this.gran_act=gran_act;
        this.razon_nit=razon_nit;
        this.casa_comercial=casa_comercial;
        this.servicio=servicio;
        this.direccion=direccion;
        this.telefono=telefono;
        this.nit=nit;
        this.estado=estado;
    }
    
    public ProveedoresData() {
        this.cod_proveedor="";
        this.cod_estado="";
        this.fax="";
        this.web="";
        this.gran_act="";
        this.razon_nit="";
        this.partida="";
        this.casa_comercial="";
        this.servicio="";
        this.direccion="";
        this.telefono="";
        this.nit="";
        this.estado="";
    }
}