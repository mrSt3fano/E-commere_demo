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
        writer.println("Nombre,Fecha,Orden,Cantidad,Precio_final,nombre_producto,marca,precio_unitario");

        for (Object[] p : Cate) {
            writer.println(p[0]+","+p[1]+","+p[2]+","+p[3]+","+p[4]+","+p[5]+","+p[6]+","+p[7]);
        }

        writer.flush();
        writer.close();


}}
