/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioServer.controller;

import com.google.gson.Gson;
import com.portafolioServer.model.Educacion;
import com.portafolioServer.model.Experiencia;
import com.portafolioServer.model.HabilidadesDurasBlandas;
import com.portafolioServer.model.ImagenBase64;
import com.portafolioServer.model.Proyecto;
import com.portafolioServer.model.SobreMi;
import com.portafolioServer.model.Usuario;
import com.portafolioServer.service.IEducacion;
import com.portafolioServer.service.IExperiencia;
import com.portafolioServer.service.IHDB;
import com.portafolioServer.service.IProyecto;
import com.portafolioServer.service.IService;
import com.portafolioServer.service.ISobreMi;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import static org.springframework.data.repository.init.ResourceReader.Type.JSON;
import org.springframework.http.HttpHeaders;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Antonio
 */
@RestController
@CrossOrigin(origins = "https://mi-portafolio-fbb13.web.app")
public class Controller {

    @Autowired
    private IService interUsuario;

    @Autowired
    private IEducacion iEdu;

    @Autowired
    private IExperiencia iExp;

    @Autowired
    private IHDB ihdb;

    @Autowired
    private IProyecto iproyec;

    @Autowired
    private ISobreMi iSobreMi;

    @GetMapping("/traerUsuarios")
    public List<Usuario> getUser() {

        return interUsuario.getUsuario();
    }

    @GetMapping("fileImagenes/{filename}")
    @CrossOrigin(origins = "https://mi-portafolio-fbb13.web.app")
    public Path fileImagenes(@PathVariable("filename") String filename) throws IOException {
        //Path filePath = Paths.get("src\\main\\java\\com\\portafolioServer\\imagenes").toAbsolutePath().normalize().resolve(filename);
       Path filePath = Paths.get("src/main/java/com/portafolioServer/imagenes").toAbsolutePath().normalize();
        return filePath;
        //System.out.println(filePath);
        //if (!Files.exists(filePath)) {
          //  throw new FileNotFoundException(filename + " was not found on the server");
        //}
        //Resource resource = new UrlResource(filePath.toUri());
       // HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.add("File-Name", filename);
        //httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
        //return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
          //      .headers(httpHeaders).body(resource);
    }

    @GetMapping("/traerUser/{id}")
    @CrossOrigin(origins = "https://mi-portafolio-fbb13.web.app")
    public Usuario unUser(@PathVariable Long id) {
        Usuario per = interUsuario.findUsuario(id);
        //try{
        //  Base64.Decoder dec = Base64.getDecoder();
// Decode
        //String ds = new String(dec.decode(per.getPassword()));
        //per.setPassword(ds);
        //}catch(Exception e){
        //  System.out.println("TODAVIA NO ESPERA XD" + e.getMessage());
        // }
        return per;
    }

    @PostMapping("/nuevoUsuario")
    public String crearPersona(@RequestBody Usuario user) {

        // Base64.Encoder enc = Base64.getEncoder();
        // String s = enc.encodeToString( user.getPassword().getBytes());
        // user.setPassword(s); 
       // if (!imagen.isEmpty()) {
         //   Path directorioImagenes = Paths.get("src\\main\\resources\\static\\imagenes");
           // String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
           // try {
             //   byte[] bytesImagen = imagen.getBytes();
               // Path rutaCompleta = Paths.get(rutaAbsoluta + "\\" + imagen.getOriginalFilename());
               // Files.write(rutaCompleta, bytesImagen);
              //  user.setFotobaner(imagen.getOriginalFilename());
           // } catch (IOException exc) {
             //   System.out.println("Error Guardando la imagen: " + exc.getMessage());
            //}
        //}
        interUsuario.savedUsuario(user);
        return "El usuario fue creado";
    }

    //@DeleteMapping("/borrarUsuario/{id}")
    //public String borrarUsuario(@PathVariable Long id) throws IOException {

        //Path filePath = Paths.get("src\\main\\resources\\static\\imagenes").toAbsolutePath().normalize().resolve("Banner.jpg");
       // Files.delete(filePath);

        //interUsuario.deletedUsuario(id);
       // return "borrado bien";
      //  return "El usuario fue eliminado";
    //}

    @PutMapping(value="/editarBanner/{id}", consumes = MULTIPART_FORM_DATA_VALUE)
    public Usuario editUsuario(@PathVariable Long id,
            @RequestParam("file") MultipartFile imagen, @RequestParam("nombreNewImagen") String nombreImagen) throws IOException {
        Usuario p = interUsuario.findUsuario(id);

       

        if (!imagen.isEmpty()) {

            Path directorioImagenes = Paths.get("src\\main\\resources\\static\\imagenes");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            try {
                byte[] bytesImagen = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "\\" + nombreImagen);

                Files.write(rutaCompleta, bytesImagen);
                Path filePath = directorioImagenes.toAbsolutePath().normalize().resolve(p.getFotobaner());
                Files.delete(filePath);

                p.setFotobaner(nombreImagen);

            } catch (IOException exc) {
                System.out.println("Error Guardando la imagen: " + exc.getMessage());
            }
        }

        interUsuario.updateUsuario(p);
        return p;
    }

    @PutMapping(value="/editarEducacion/{id}", consumes = MULTIPART_FORM_DATA_VALUE)
    public Educacion EditEducacion(@PathVariable Long id,
            @RequestParam("educacion")String data, @RequestParam("file") MultipartFile imagen, @RequestParam("nombreNewImagen") String nombreImagen) {
        
        Gson g = new Gson();

         Educacion educacion = g.fromJson(data, Educacion.class);
        
        Educacion ed = iEdu.findEducacion(id);

        if (educacion.getId() != null) {
            ed.setId(educacion.getId());
        }

        if (educacion.getFormacion() != null) {
            ed.setFormacion(educacion.getFormacion());
        }

        if (!imagen.isEmpty()) {

            Path directorioImagenes = Paths.get("src\\main\\resources\\static\\imagenes");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            try {
                byte[] bytesImagen = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "\\" + nombreImagen);

                Files.write(rutaCompleta, bytesImagen);
                Path filePath = directorioImagenes.toAbsolutePath().normalize().resolve(ed.getFoto());
                Files.delete(filePath);

                ed.setFoto(nombreImagen);

            } catch (IOException exc) {
                System.out.println("Error Guardando la imagen: " + exc.getMessage());
            }
        }

        if (educacion.getInstitucion() != null) {
            ed.setInstitucion(educacion.getInstitucion());
        }
        if (educacion.getRealizacion() != null) {
            ed.setRealizacion(educacion.getRealizacion());
        }

        this.iEdu.updateEducacion(ed);
        return ed;

    }
    
    @DeleteMapping("/borrarInfoEducacion/{id}")
    public String borrarInfoEducacion(@PathVariable Long id) {
        this.iEdu.deletedEducacion(id);
        return "Info borrada";
    }

    @PutMapping(value="/editarExperiencia/{id}", consumes = MULTIPART_FORM_DATA_VALUE)
    public Experiencia EditExperiencia(@PathVariable Long id,
            @RequestParam("experiencia") String data, @RequestParam("file") MultipartFile imagen, @RequestParam("nombreNewImagen") String nombreImagen) {
      
        
        Gson g = new Gson();

         Experiencia experiencia = g.fromJson(data, Experiencia.class);
        
        
        Experiencia exp = this.iExp.findExperiencia(id);

        if (experiencia.getId() != null) {
            exp.setId(experiencia.getId());
        }
        if (experiencia.getActividad() != null) {
            exp.setActividad(experiencia.getActividad());
        }
        if (experiencia.getEmpresa() != null) {
            exp.setEmpresa(experiencia.getEmpresa());
        }
        if (experiencia.getPeriodo() != null) {
            exp.setPeriodo(experiencia.getPeriodo());
        }
        if (!imagen.isEmpty()) {

            Path directorioImagenes = Paths.get("src\\main\\resources\\static\\imagenes");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            try {
                byte[] bytesImagen = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "\\" + nombreImagen);

                Files.write(rutaCompleta, bytesImagen);
                Path filePath = directorioImagenes.toAbsolutePath().normalize().resolve(exp.getFoto());
                Files.delete(filePath);

                exp.setFoto(nombreImagen);

            } catch (IOException exc) {
                System.out.println("Error Guardando la imagen: " + exc.getMessage());
            }
        }

        this.iExp.updateExperiencia(exp);
        return exp;
    }
    
     @DeleteMapping("/borrarInfoExperiencia/{id}")
    public String borrarInfoExperiencia(@PathVariable Long id) {
        this.iExp.deletedExperiencia(id);
        return "Info borrada";
    }
    

    @PutMapping("/editarHdb/{id}")
    public HabilidadesDurasBlandas EditHDB(@PathVariable Long id,
            @RequestBody HabilidadesDurasBlandas habilidades) {

        HabilidadesDurasBlandas hdb = this.ihdb.findHabilidadesDurasBlandas(id);

        if (habilidades.getId() != null) {
            hdb.setId(habilidades.getId());
        }
        if (habilidades.getNombre() != null) {
            hdb.setNombre(habilidades.getNombre());
        }
        if (habilidades.getNivel() > 0) {
            hdb.setNivel(habilidades.getNivel());
        }

        this.ihdb.updateHabilidadesDurasBlandas(hdb);
        return hdb;
    }
    
     @DeleteMapping("/borrarInfoHdb/{id}")
    public String borrarInfoHdb(@PathVariable Long id) {
        this.ihdb.deletedHabilidadesDurasBlandas(id);
        return "Info borrada";
    }

    @PutMapping("/editarProyecto/{id}")
    public Proyecto editarProyecto(@PathVariable Long id,
            @RequestBody Proyecto proyecto) {
        Proyecto proc = this.iproyec.findProyecto(id);

        if (proyecto.getId() != null) {
            proc.setId(proyecto.getId());
        }

        if (proyecto.getNombre() != null) {
            proc.setNombre(proyecto.getNombre());
        }

        if (proyecto.getDescripcion() != null) {
            proc.setDescripcion(proyecto.getDescripcion());
        }

        if (proyecto.getRealizacion() != null) {
            proc.setRealizacion(proyecto.getRealizacion());
        }

        if (proyecto.getLink() != null) {
            proc.setLink(proyecto.getLink());
        }

        this.iproyec.updateProyecto(proc);
        return proc;
    }
    @DeleteMapping("/borrarInfoProyecto/{id}")
    public String borrarInfoProyecto(@PathVariable Long id) {
        this.iproyec.deletedProyecto(id);
        return "Info borrada";
    }
   

    @PutMapping(value = "/editarSobreMi/{id}", consumes = MULTIPART_FORM_DATA_VALUE)
    public SobreMi editarSobreMi(@PathVariable Long id,
               @RequestParam("file") MultipartFile image, @RequestParam("sobreMi") String data, @RequestParam("nombreNewImagen") String nombreImagen) throws IOException   {
                

         Gson g = new Gson();

         SobreMi sobreMi = g.fromJson(data, SobreMi.class);
        
        SobreMi sm = this.iSobreMi.findSobreMi(id);

        if (sobreMi.getId() != null) {
            sm.setId(sobreMi.getId());
        }
        if (sobreMi.getNombre() != null) {
            sm.setNombre(sobreMi.getNombre());
        }
        if (sobreMi.getApellido() != null) {
            sm.setApellido(sobreMi.getApellido());
        }
        if (sobreMi.getTitulo() != null) {
            sm.setTitulo(sobreMi.getTitulo());
        }
        
         if (!image.isEmpty()) {

             Path directorioImagenes = Paths.get("src\\main\\resources\\static\\imagenes");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
            
            try {
                
        
        
               byte[] bytesImagen = image.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "\\" + nombreImagen);

                Files.write(rutaCompleta, bytesImagen);
                Path filePath = directorioImagenes.toAbsolutePath().normalize().resolve(sm.getFotoperfil());
                Files.delete(filePath);

                sm.setFotoperfil(nombreImagen);

            } catch (IOException exc) {
                System.out.println("Error Guardando la imagen: " + exc.getMessage());
            }
        }
        
        if (sobreMi.getCorreo() != null) {
            sm.setCorreo(sobreMi.getCorreo());
        }
        if (sobreMi.getSobreMi() != null) {
            sm.setSobreMi(sobreMi.getSobreMi());
        }

        this.iSobreMi.updateSobreMi(sm);
        return sm;
    }
    //@DeleteMapping("/borrarInfoSobreMi/{id}")
   // public String borrarInfoSobreMi(@PathVariable Long id) {
        //SobreMi sm = this.iSobreMi.findSobreMi(id);
        
     //   this.iSobreMi.deletedSobreMi(id);
       // return "Info borrada";
    //}

}
