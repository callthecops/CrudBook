package com.example.CrudBook.model.Institution;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InstitutionForm {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 16)
    private String name;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 16)
    private String address;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 25)
    private String institution;


    public InstitutionForm(@NotNull @NotBlank @Size(min = 3, max = 16) String name, @NotBlank @NotNull @Size(min = 2, max = 16) String address, @NotBlank @NotNull @Size(min = 2, max = 25) String institution) {
        this.name = name;
        this.address = address;
        this.institution = institution;
    }

    public InstitutionForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
