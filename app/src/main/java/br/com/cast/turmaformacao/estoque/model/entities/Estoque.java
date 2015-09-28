package br.com.cast.turmaformacao.estoque.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Estoque implements Parcelable {

    @JsonIgnore
    private Long _id;

    @JsonProperty("id")
    private Long idWeb;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("stock")
    private Long quant;

    @JsonProperty("minimunStock")
    private Long minQuant;

    @JsonProperty("unitaryValue")
    private Double value;

    @JsonProperty("image")
    private String image;

    @JsonProperty("date")
    private Long date;

    @JsonIgnore
    public Long get_Id() {
        return _id;
    }

    @JsonIgnore
    public void set_Id(Long _id) {
        this._id = _id;
    }

    @JsonSetter("id")
    public Long getIdWeb() {
        return idWeb;
    }

    @JsonGetter("id")
    public void setIdWeb(Long idWeb) {
        this.idWeb = idWeb;
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

    public Long getQuant() {
        return quant;
    }

    public void setQuant(Long quant) {
        this.quant = quant;
    }

    public Long getMinQuant() {
        return minQuant;
    }

    public void setMinQuant(Long minQuant) {
        this.minQuant = minQuant;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estoque estoque = (Estoque) o;

        if (_id != null ? !_id.equals(estoque._id) : estoque._id != null) return false;
        if (name != null ? !name.equals(estoque.name) : estoque.name != null) return false;
        if (description != null ? !description.equals(estoque.description) : estoque.description != null)
            return false;
        if (quant != null ? !quant.equals(estoque.quant) : estoque.quant != null) return false;
        if (minQuant != null ? !minQuant.equals(estoque.minQuant) : estoque.minQuant != null)
            return false;
        if (value != null ? !value.equals(estoque.value) : estoque.value != null) return false;
        if (image != null ? !image.equals(estoque.image) : estoque.image != null) return false;
        if (idWeb != null ? !idWeb.equals(estoque.idWeb) : estoque.idWeb != null) return false;
        return !(date != null ? !date.equals(estoque.date) : estoque.date != null);

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (quant != null ? quant.hashCode() : 0);
        result = 31 * result + (minQuant != null ? minQuant.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (idWeb != null ? idWeb.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quant=" + quant +
                ", minQuant=" + minQuant +
                ", value=" + value +
                ", image='" + image + '\'' +
                ", idWeb=" + idWeb +
                ", date=" + date +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this._id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeValue(this.quant);
        dest.writeValue(this.minQuant);
        dest.writeValue(this.value);
        dest.writeString(this.image);
        dest.writeValue(this.idWeb);
        dest.writeValue(this.date);
    }

    public Estoque() {
    }

    protected Estoque(Parcel in) {
        this._id = (Long) in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
        this.description = in.readString();
        this.quant = (Long) in.readValue(Long.class.getClassLoader());
        this.minQuant = (Long) in.readValue(Long.class.getClassLoader());
        this.value = (Double) in.readValue(Double.class.getClassLoader());
        this.image = in.readString();
        this.idWeb = (Long) in.readValue(Long.class.getClassLoader());
        this.date = (Long) in.readValue(Long.class.getClassLoader());
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