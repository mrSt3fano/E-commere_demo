package com.sistema.regisstro.Sistemademo.Controller;

import com.sistema.regisstro.Sistemademo.AccessDB.Operaciones;
import com.sistema.regisstro.Sistemademo.Service.Ecommerce.Category.ServicioCategorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.List;

@Controller
public class ExportController {

    @Autowired
    private ServicioCategorias sata;
    private Operaciones op;

    public ExportController(ServicioCategorias sata, Operaciones op) {
        this.sata = sata;
        this.op=op;
    }

    @GetMapping("/exportar-csv")
    public void exportarCsv(HttpServletResponse response) throws Exception {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=dataset1.csv");

        List<Object[]> Cate = op.obtenerConsultasGenerales();

        String rutaArchivo = "C:/ruta/donde/guardar/productos.csv";

        PrintWriter writer = response.getWriter();
        writer.println("Nombre,Contraseña,Fecha,Orden,Cantidad,Precio_Unitario,Precio_Final," +
                "Nombre_Producto,Categoria,Descripcion,Marca,Tipo_Producto,Nombre_Proveedor," +
                "Ciudad,Nombre_Compañia,Telefono");
        int i=0;

        for (Object[] p : Cate) {
            writer.println(p[0]+","+p[1]+","+p[2]+","+p[3]+","+p[4]+","+p[5]+","+p[6]+","+p[7]+","+p[8]+
                    ","+p[9]+","+p[10]+","+p[11]+","+p[12]+","+p[13]+","+p[14]+","+p[15]);
        }

        writer.flush();
        writer.close();


}}
