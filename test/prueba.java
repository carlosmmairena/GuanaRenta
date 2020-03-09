
import com.guanarenta.clases.Vivienda;
import com.guanarenta.connections.Enlace;
import com.guanarenta.connections.OperacionesVivienda;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Copyright (C) 2020 dreads
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author dreads
 */
public class prueba {
    
    public static void main(String s[]){
        
        try {
            OperacionesVivienda opera = new OperacionesVivienda();
            Vivienda vivi = new Vivienda();
            
            opera.guardarVivienda(Enlace.crearEnlace(), vivi);
            
            System.out.println("Vivienda guardada");
        } catch (SQLException ex) {
            System.err.println(ex.getCause());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
