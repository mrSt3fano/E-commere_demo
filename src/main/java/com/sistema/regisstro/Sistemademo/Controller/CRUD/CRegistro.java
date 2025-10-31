package com.sistema.regisstro.Sistemademo.Controller.CRUD;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import com.sistema.regisstro.Sistemademo.AccessDB.SpringREST.BoletaData;
import com.sistema.regisstro.Sistemademo.AccessDB.SpringREST.VentasData;
import com.sistema.regisstro.Sistemademo.Entity.*;
import com.sistema.regisstro.Sistemademo.DTO.WebCategory;
import com.sistema.regisstro.Sistemademo.DTO.WebProduct;
import com.sistema.regisstro.Sistemademo.DTO.WebUser;
import com.sistema.regisstro.Sistemademo.Service.Ecommerce.Category.ServicioCategorias;
import com.sistema.regisstro.Sistemademo.Service.Ecommerce.Product.ServicioProductos;
import com.sistema.regisstro.Sistemademo.Service.Ecommerce.Sale.ServicioVentas;
import com.sistema.regisstro.Sistemademo.Service.Ecommerce.SalesTicket.ServicioBoletas;
import com.sistema.regisstro.Sistemademo.Service.Usuario.Servicio;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registrar")
public class CRegistro {

    private Logger log = Logger.getLogger(getClass().getName());
    private Servicio serv;
    private ServicioCategorias servcat;
    private ServicioProductos servprod;
    private ServicioBoletas servbol;
    private ServicioVentas boletafinal;
    private BoletaData ultimo;
    private VentasData generarFinal;

    @Autowired
    public CRegistro(VentasData aqq, BoletaData af,Servicio serv, ServicioCategorias saf, ServicioProductos aa, ServicioBoletas s, ServicioVentas v) {
        this.serv = serv;
        this.servcat=saf;
        this.servprod=aa;
        this.servbol=s;
        this.boletafinal=v;
        this.ultimo=af;
        this.generarFinal=aqq;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/nuevoUsuario")
    public String showMyLoginPage(Model mo) {
        mo.addAttribute("webUser", new WebUser());
        return "/Login-SignUp/registro-usuario";
    }


    @PostMapping("/procesoRegistracion")
    public String processRegistrationForm(
            @Valid @ModelAttribute("webUser") WebUser nuevo,
            BindingResult theBindingResult,
            HttpSession session, Model theModel)
    {
        String nuevousuario = nuevo.getNombre();
        log.info("Procesando registro para: " + nuevousuario);

        if (theBindingResult.hasErrors()){
            return "/Login-SignUp/registro-usuario";}

        //verificar si el usuario existe
        Usuario existing = serv.encontrarUsuarioAhora(nuevousuario);
        if (existing != null){
            theModel.addAttribute("webUser", new WebUser());
            theModel.addAttribute("registrationError", "El usuario ya existe.");

            log.warning("Nombre de usuario ya existe");
            return "/Login-SignUp/registro-usuario";
        }

        //guardar usuario en la base de datos
        Usuario asd=serv.guardarUsuario(nuevo);

        log.info("Usuario creado satisfactoriamente: " + nuevousuario);

        // place user in the web http session for later use
        session.setAttribute("user", nuevo);
        theModel.addAttribute("usuarioregistrado",asd);

        return "/Login-SignUp/registro-confirmacion";
    }

    //registro categorias nuevas
    @GetMapping("/categoria")
    public String registrarnuevacategoria(Model mo){
        mo.addAttribute("webCategoria", new WebCategory());
        return "/Gerency/Forms_Ecommerce/NewCategoy";
    }

    @PostMapping("/procesarcategoria")
    public String procesarcategorianueva(Model theModel,
            @Valid @ModelAttribute("webCategoria") WebCategory nuevo)
    {
        Categorias cate=servcat.guardarCategorias(nuevo);
        theModel.addAttribute("categoriaregistrado",cate);
        return "/Gerency/consultasDeAdmin";
    }

    //registro de nuevos productos
    @GetMapping("/productos")
    public String registrarnuevosproductos(Model mo){
        mo.addAttribute("webProductos", new WebProduct());
        List<Categorias> ses=servcat.consultaCategorias();
        mo.addAttribute("imprimir",ses);
        return "/Gerency/Forms_Ecommerce/NewProduct";
    }

    @PostMapping("/procesarproducto")
    public String procesasnuevosproductos(Model theModel,
                  @Valid @ModelAttribute WebProduct nuevo)
    {
        Productos cate=servprod.guardarProductos(nuevo);
        theModel.addAttribute("productoregistrado",cate);
        return "/Gerency/consultasDeAdmin";
    }

    @PostMapping("/generarBoleta")
    public String generarBoletaa(Authentication usuarioact,
                                 @RequestParam("cantidad") int c,
                                 @RequestParam("productoid") int prodid, Model mo){

        Productos pp=servprod.consultaProductoID(prodid);

        String usuario = usuarioact.getName();
        Usuario userencontrado=serv.encontrarUsuarioAhora(usuario);
        int ides=userencontrado.getId();
        LocalDateTime dt=LocalDateTime.now();

        Pedido pedido =new Pedido();
        pedido.setUs(userencontrado);
        pedido.setFecha(dt);
        pedido.setOrden(1);

        ultimo.save(pedido);

        Ventas ventas=new Ventas();
        ventas.setProd2(pp);
        ventas.setPedido(pedido);
        ventas.setCantidad(c);
        ventas.setPrecioventa(12.0);


        generarFinal.save(ventas);

        mo.addAttribute("ventafinal",ventas);
        mo.addAttribute("fecha",pedido.getFecha());
        mo.addAttribute("usuario",userencontrado);
        mo.addAttribute("producto",pp);
        return "/Shopping/Boleta";
    }




}
