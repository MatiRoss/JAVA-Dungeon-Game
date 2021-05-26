package database;

import characters.Character;
import characters.Inventory;
import characters.Warrior;
import characters.Wizard;
import equipments.Protections;
import equipments.Weapons;

import java.sql.*;

public class Database {

    String dburl;
    Connection con;

    public Database() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        dburl = "jdbc:mariadb://localhost:3307/varknight";
        con = DriverManager.getConnection(dburl, "root", "");
    }

    public void insertNewHero(Character player) {
        ResultSet resultSet = null;
        String role = "";
        if (player instanceof Warrior) {
            role = "Guerrier";
        } else {
            role = "Magicien";
        }

        String names = player.getName();
        int hp = player.getHp();
        int attack = player.getAttack();
        Weapons weapon = player.getInventory().getWeapons();
        Protections protection = player.getInventory().getProtections();

        String req = "INSERT INTO hero VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(req);
            ps.setInt(1, 2);
            ps.setObject(2, player);
            ps.setString(3, role);
            ps.setString(4, names);
            ps.setInt(5, hp);
            ps.setInt(6, attack);
            if (weapon == null) {
                ps.setString(7, "Aucune arme");
            } else {
                ps.setString(7, weapon.toString());
            }
            if (protection == null) {
                ps.setString(8, "Aucune protection");
            } else {
                ps.setString(8, protection.toString());
            }
            ps.executeUpdate();
            Statement stmt = con.createStatement();
            //     resultSet = stmt.executeQuery(req);
        } catch (SQLException e) {
            System.out.println("Erreur" + e);
        }
    }

    public void updateHero(Character player) throws SQLException {

        String req = "UPDATE hero SET hp = ?, attack = ?, weapon = ?, protection = ? WHERE name = ?";
        PreparedStatement updateHero = con.prepareStatement(req);
        updateHero.setInt(1, player.getHp());
        updateHero.setInt(2, player.getAttack());
        if (player instanceof Warrior) {
            if (((Warrior) player).getWeapon() == null) {
                updateHero.setString(3, "Aucune arme");
            } else {
                updateHero.setString(3, ((Warrior) player).getWeapon().toString());
            }
        } else if (player instanceof Wizard) {
            if (((Wizard) player).getWeapon() == null) {
                updateHero.setString(3, "Aucune arme");
            } else {
                updateHero.setString(3, ((Wizard) player).getWeapon().toString());
            }
        }
        if (player instanceof Warrior) {
            if (((Warrior) player).getProtection() == null) {
                updateHero.setString(4, "Aucune protection");
            } else {
                updateHero.setString(4, ((Warrior) player).getProtection().toString());
            }
        } else if (player instanceof Wizard) {
            if (((Wizard) player).getProtection() == null) {
                updateHero.setString(4, "Aucune protection");
            } else {
                updateHero.setString(4, ((Wizard) player).getProtection().toString());
            }
        }
        updateHero.setString(5, player.getName());
        try {
            updateHero.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur");
            System.out.println(e);
        }
    }

    public void displayHeroes() throws SQLException {
        String reqHero = "SELECT * FROM hero";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(reqHero);

        int i = 1;
        while (rs.next()) {
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(2));
            System.out.println("ATK : " + rs.getString(4) + "                          [" + i + "] CHOISIR CE PERSONNAGE");
            System.out.println("HP : " + rs.getString(5));
            System.out.println(rs.getString(6));
            System.out.println(rs.getString(7));
            System.out.println("");
            System.out.println("");
            i++;
        }
    }

    public void loadHero(Character player) throws SQLException {
        String reqHero = "SELECT * FROM hero";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(reqHero);

        if (player instanceof Warrior) {
            player.setName(rs.getString(4));
            player.setHp(rs.getInt(5));
            player.setAttack(rs.getInt(6));
            ((Warrior) player).setWeapon((Weapons) rs.getObject(7));
            ((Warrior) player).setProtection((Protections) rs.getObject(8));
        } else {
            player.setName(rs.getString(4));
            player.setHp(rs.getInt(5));
            player.setAttack(rs.getInt(6));
            ((Wizard) player).setWeapon((Weapons) rs.getObject(7));
            ((Wizard) player).setProtection((Protections) rs.getObject(8));
        }
    }
}
