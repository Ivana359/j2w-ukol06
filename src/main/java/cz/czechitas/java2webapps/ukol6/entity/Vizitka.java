package cz.czechitas.java2webapps.ukol6.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;


@Entity
public class Vizitka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Length(max = 100)
    @NotBlank (message = "Jméno a příjmení musí být vyplněno. ")
    String celeJmeno;

    @Length(max = 100)
    @NotBlank(message = "Název firmy musí být vyplněn. ")
    String firma;

    @Length(max = 100)
    @NotBlank (message = "Vyplňte ulici a číslo domu. ")
    String ulice;

    @Length(max = 100)
    @NotBlank (message = "Vyplňte obec. ")
    String obec;

    @Length(min = 5, max = 5)
    @NotBlank(message = "Vyplňte PSČ. ")
    String psc;

    @Length(max = 100)
    @Email(message = "Zadejte platnou emailovou adresu.")
    String email;

    @Length(max = 100)
    @Pattern(regexp = "\\+?[0-9]+", message = "Zadejte platné telefonní číslo.")
    String telefon;

    @Length(max = 20)
    String web;

    public String celaAdresa (){
        return ulice + " " + obec + " " + psc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {
        this.celeJmeno = celeJmeno;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
