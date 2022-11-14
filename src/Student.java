public class Student implements Human{
    protected String _nume;
    protected String _prenume;
    protected String _acronimFac;
    protected Integer _varsta;
    protected Integer _anStudiu;

    public Student(String nume, String prenume, String acronimFac, Integer varsta, Integer anStudiu) {
        this._nume = nume;
        this._prenume = prenume;
        this._acronimFac = acronimFac;
        this._varsta = varsta;
        this._anStudiu = anStudiu;
    }

    public String get_nume() {
        return _nume;
    }

    public void set_nume(String _nume) {
        this._nume = _nume;
    }

    public String get_prenume() {
        return _prenume;
    }

    public void set_prenume(String _prenume) {
        this._prenume = _prenume;
    }

    public String get_acronimFac() {
        return _acronimFac;
    }

    public void set_acronimFac(String _acronimFac) {
        this._acronimFac = _acronimFac;
    }

    public Integer get_varsta() {
        return _varsta;
    }

    public void set_varsta(Integer _varsta) {
        this._varsta = _varsta;
    }

    public Integer get_anStudiu() {
        return _anStudiu;
    }

    public void set_anStudiu(Integer _anStudiu) {
        this._anStudiu = _anStudiu;
    }

    @Override
    public void greeting() {

    }

    @Override
    public void doWord() {

    }

    @Override
    public String toString() {
        return "Sd. " + this._nume + " " + this._prenume + " Anul " + this._anStudiu + " Fac. " + this._acronimFac + " Varsta: " + this._varsta;
    }
}
