package database;

import characters.Character;
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
        Class<? extends Character> typex = player.getClass();
        String names = player.getName();
        int hp = player.getHp();
        int attack = player.getAttack();
        Weapons weapon = player.getInventory().getWeapons();
        Protections protection = player.getInventory().getProtections();

        String req = "INSERT INTO hero VALUES (3, '" + typex + "', '" + names + "', '" + hp + "', '" + attack + "', '" + weapon + "', '" + protection + "')";

        try {
            Statement stmt = con.createStatement();
            resultSet = stmt.executeQuery(req);
        } catch (SQLException e) {
            //traitement de l'exception
        }
    }

    public void getHeroes() {

    }
}
