package com.sistema.regisstro.Sistemademo.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class WebUser {

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String nombre;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;

	private MultipartFile imagene;

	public WebUser() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MultipartFile getImagene() {
		return imagene;
	}

	public void setImagene(MultipartFile imagene) {
		this.imagene = imagene;
	}
}
