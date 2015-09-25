package br.com.cast.turmaformacao.estoque.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Estoque implements Parcelable {

    private Long id;
    private String name;
    private String description;
    private Integer quant;
    private Integer minQuant;
    private Double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Integer getMinQuant() {
        return minQuant;
    }

    public void setMinQuant(Integer minQuant) {
        this.minQuant = minQuant;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estoque estoque = (Estoque) o;

        if (id != null ? !id.equals(estoque.id) : estoque.id != null) return false;
        if (name != null ? !name.equals(estoque.name) : estoque.name != null) return false;
        if (description != null ? !description.equals(estoque.description) : estoque.description != null)
            return false;
        if (quant != null ? !quant.equals(estoque.quant) : estoque.quant != null) return false;
        if (minQuant != null ? !minQuant.equals(estoque.minQuant) : estoque.minQuant != null)
            return false;
        return !(value != null ? !value.equals(estoque.value) : estoque.value != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (quant != null ? quant.hashCode() : 0);
        result = 31 * result + (minQuant != null ? minQuant.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quant=" + quant +
                ", minQuant=" + minQuant +
                ", value=" + value +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeValue(this.quant);
        dest.writeValue(this.minQuant);
        dest.writeValue(this.value);
    }

    public Estoque() {
    }

    protected Estoque(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
        this.description = in.readString();
        this.quant = (Integer) in.readValue(Integer.class.getClassLoader());
        this.minQuant = (Integer) in.readValue(Integer.class.getClassLoader());
        this.value = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Creator<Estoque> CREATOR = new Creator<Estoque>() {
        public Estoque createFromParcel(Parcel source) {
            return new Estoque(source);
        }

        public Estoque[] newArray(int size) {
            return new Estoque[size];
        }
    };
}