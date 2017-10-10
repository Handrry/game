package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Game;
import util.DBUtil;

public class GameDao implements Serializable {
	
	/**
	 * ������ϷIDɾ����Ϸ
	 */
	public void deleteByID(Integer id){
		try {
			Connection  conn = DBUtil.getConnection();
			String sql = "delete from game where game_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�Ҳ���������",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ɾ��ʧ��",e);
		} finally {
			DBUtil.colseConnection();
		}
		
	}
	
	/**
	 * ���һ����Ϸ
	 */
	public void addGame(Game g){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "INSERT INTO game (name,rank,gametype,inform,gametime,gameimg)"
					+ "VALUES(?,?,?,?,now(),?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, g.getName());
			ps.setInt(2, g.getRank());
			ps.setString(3, g.getGameType());
			ps.setString(4, g.getInform());
			ps.setString(5, g.getGameImg());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�Ҳ���������");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ʧ��");
		} finally {
			DBUtil.colseConnection();
		}
		
	}
	
	/**
	 * ��ѯ������Ϸ��Ϣ
	 * */
	public List<Game> findAllGame(){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "SELECT * FROM game";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			List<Game> list = new ArrayList<Game>();
			while(rs.next()){
				Game game = getGame(rs);
				list.add(game);
			}
			return list;		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�Ҳ���������",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��",e);
		} finally {
			DBUtil.colseConnection();
		}
	}
	// ��һ�������ȡ��
	public Game getGame(ResultSet rs) throws SQLException{
		Game game = new Game();
		game.setGame_id(rs.getInt(1));
		game.setName(rs.getString(2));
		game.setRank(rs.getInt(3));
		game.setGameType(rs.getString(4));
		game.setInform(rs.getString(5));
		game.setGameTime(rs.getTimestamp(6));
		game.setGameImg(rs.getString(7));
		return game;
	}
	
	/**
	 * ��Ϸ�ķ�ҳ��ѯ
	 * */
	public List<Game> findBySize(int page,int size){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from game ORDER BY rank limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*size);
			ps.setInt(2, size);
			List<Game> list = new ArrayList<Game>();
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Game game = new Game();
				game.setGame_id(rs.getInt(1));
				game.setName(rs.getString(2));
				game.setRank(rs.getInt(3));
				game.setGameType(rs.getString(4));
				game.setInform(rs.getString(5));
				game.setGameTime(rs.getTimestamp(6));
				game.setGameImg(rs.getString(7));
				list.add(game);				
			}
			return list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�Ҳ���������",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��",e);
		}
	}
	
	// ��ѯ��ҳ��
	public int findRow(){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select count(*) from game";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.colseConnection();
		}
		return 0;
	}
	
	/**
	 * ������Ϸ����ѯ
	 * */
	public Game findByName(String name){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "SELECT * FROM game WHERE g_name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			Game game = new Game();
			if(rs.next()){
				game.setGame_id(rs.getInt(1));
				game.setName(rs.getString(2));
				game.setRank(rs.getInt(3));
				game.setGameType(rs.getString(4));
				game.setInform(rs.getString(5));
				game.setGameTime(rs.getTimestamp(6));
				game.setGameImg(rs.getString(7));
			}
			return game;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�Ҳ���������",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��",e);
		}
	}
	
	
	
	/**
	 * ����Ϸ�ķ����ѯ��Ϸ����
	 * */
	public List<Game> findAllName(String type){
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "SELECT * FROM game WHERE gametype=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			List<Game> list = new ArrayList<Game>();
			while(rs.next()){
				Game game = getGame(rs);
				list.add(game);
			}
			return list;		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("�Ҳ���������",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯʧ��",e);
		} finally {
			DBUtil.colseConnection();
		}
	}

	
	public static void main(String[] args) {
		GameDao dao = new GameDao();
		List<Game> list = dao.findAllName("ð��");
		System.out.println(list);
	}
	
}
