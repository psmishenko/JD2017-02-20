package by.it.ikavalenka.jd03_02.beans;

import java.util.HashMap;

/**
 * Created by USER on 09.05.2017.
 */
public class blacklist {
    private int Black_list_ID;
    private int Client_id_fk;

    public int getBlack_list_ID() {
        return Black_list_ID;
    }

    public void setBlack_list_ID(int black_list_ID) {
        this.Black_list_ID = black_list_ID;
    }

    public int getClient_id_fk() {
        return Client_id_fk;
    }

    public void setClient_id_fk(int client_id_fk) {
        this.Client_id_fk = client_id_fk;
    }




    @Override
    public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
         blacklist blacklist = (blacklist) obj;
         if (Black_list_ID != blacklist.Black_list_ID) return false;
         if (Client_id_fk != blacklist.Client_id_fk) return  false;
            return true;
    }

    @Override
    public int hashCode() {
        int result = Black_list_ID;
        result = 31 * result+ Client_id_fk;
        return result;
    }

    public blacklist(int black_list_id, int client_id_fk){}

    @Override
    public String toString() {
        return "blacklist{" + "Black_list_ID" + Black_list_ID
+", Client_id_fk" + Client_id_fk +"}";
    }
}
