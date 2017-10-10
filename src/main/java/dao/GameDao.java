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
	 * 根据游戏ID删除游戏
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
			throw new RuntimeException("找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败",e);
		} finally {
			DBUtil.colseConnection();
		}
		
	}
	
	/**
	 * 添加一条游戏
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
			throw new RuntimeException("找不到驱动类");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败");
		} finally {
			DBUtil.colseConnection();
		}
		
	}
	
	/**
	 * 查询所有游戏信息
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
			throw new RuntimeException("找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		} finally {
			DBUtil.colseConnection();
		}
	}
	// 将一个结果及取出
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
	 * 游戏的分页查询
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
			throw new RuntimeException("找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		}
	}
	
	// 查询总页数
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
	 * 根据游戏名查询
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
			throw new RuntimeException("找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		}
	}
	
	
	
	/**
	 * 按游戏的分类查询游戏名字
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
			throw new RuntimeException("找不到驱动类",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		} finally {
			DBUtil.colseConnection();
		}
	}

	
	public static void main(String[] args) {
		GameDao dao = new GameDao();
		List<Game> list = dao.findAllName("冒险");
		System.out.println(list);
	}
	
}
