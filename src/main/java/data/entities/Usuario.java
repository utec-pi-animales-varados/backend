package data.entities;

import com.google.common.hash.Hashing;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name="usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OneToMany(cascade = CascadeType.ALL, targetEntity = Reporte.class)
    //@JoinColumn(name = "id_report")
    //@OneToMany(mappedBy = "usuario")
    //private Set<Reporte> reporte = new HashSet<>();

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String telephone;

    @Column
    private String mobilePhone;

    public Usuario() {
    }

    public Usuario(Set<Reporte> reporte, String name, String lastName, String email, String password, String telephone, String mobilePhone) {
        //this.reporte = reporte;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.mobilePhone = mobilePhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Set<Reporte> getReports() {
        return reporte;
    }

    public void setReports(Set<Reporte> reports) {
        this.reporte = reports;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public boolean verifyPassword(String password){
        return this.password.equals(Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString());
    }


}
