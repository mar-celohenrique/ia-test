package br.marcelo.userapi.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Paper implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Paper() {
    }

    public Paper(Type type) {
        this.type = type;
    }

    public enum Type {
        ADMIN("Admin"), USER("User");

        private String description;

        private Type(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String getAuthority() {
        return this.type.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Paper other = (Paper) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
