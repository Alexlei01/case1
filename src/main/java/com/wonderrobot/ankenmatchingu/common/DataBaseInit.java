package com.wonderrobot.ankenmatchingu.common;
//DataBaseInit.vm
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wonderfulfly.core.util.StringUtil;
import com.wonderfulfly.core.util.log.LoggerUtil;


@Configuration
public class DataBaseInit {
	@Value("${spring.datasource.driver-class-name}")
	private String databaseDriver;
	@Value("${spring.datasource.root-url}")
	private String databaseUrl;
	@Value("${spring.datasource.username}")
	private String databaseUserName;
	@Value("${spring.datasource.password}")
	private String databasePwd;

	private void makeDatabase(Statement statement) {
		StringBuilder sqlScript = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader("ddl_define.sql"))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!StringUtil.isNullOrBlank(line)) {
					sqlScript.append(line).append("\n");
					if (line.endsWith(";")) {
						try {
							statement.execute(sqlScript.toString());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						sqlScript.setLength(0);
					}
				}

			}
		} catch (IOException e) {
			System.out.println("Error reading SQL file: " + e.getMessage());
		}
	}
	private void menuTablesReLoad(Statement statement) {
		try (BufferedReader br = new BufferedReader(new FileReader("ddl_define.sql"))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!StringUtil.isNullOrBlank(line)) {
					if (line.contains("USE")) {
						try {
							statement.execute(line);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				}

			}
		} catch (IOException e) {
			System.out.println("Error reading SQL file: " + e.getMessage());
		}

		dropMenuTalbes(statement);

		StringBuilder sqlScript = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader("ddl_define.sql"))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!StringUtil.isNullOrBlank(line)) {
					String sqlString = line;
					line = line.toLowerCase();
					if (line.contains("into wf_page_right_tbl") || line.contains("into wf_page_tbl")
							|| line.contains("into wf_menu_tbl") || line.contains("into wf_group_tbl")) {
						statement.execute(sqlString);
					} else {
						if ((line.contains("wf_page_right_tbl") || line.contains("wf_page_tbl")
								|| line.contains("wf_menu_tbl") || line.contains("wf_group_tbl"))
								&& line.contains("create table")) {
							sqlScript.append(line).append("\n");
						} else {
							if (sqlScript.length() > 0) {
								sqlScript.append(line).append("\n");
								if (line.endsWith(";")) {
									statement.execute(sqlScript.toString());
									sqlScript.setLength(0);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error reading SQL file: " + e.getMessage());
		}
	}

	private void dropMenuTalbes(Statement statement) {
		List<String> tables = new ArrayList<String>();
		tables.add("wf_page_right_tbl");
		tables.add("wf_page_tbl");
		tables.add("wf_menu_tbl");
		tables.add("wf_group_tbl");
		try {
			for (String table : tables) {
				statement.execute("drop table " + table);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Bean
	public void connectByJDBC() {
		try {
			Class.forName(databaseDriver);
			Connection conn = DriverManager.getConnection(databaseUrl, databaseUserName, databasePwd);
			Statement statement = conn.createStatement();
			String checkSQL = "SELECT COUNT(*) as count FROM information_schema.tables WHERE table_schema = 'ANKENMATCHINGU'";
			ResultSet resultSet = statement.executeQuery(checkSQL);
			int count = 0;
			while (resultSet.next()) {
				count = resultSet.getInt("count");
			} 
			if (count == 0) {
				LoggerUtil.debug("init database start......");
				makeDatabase(statement);
				LoggerUtil.debug("init database end......");
			}else {
				menuTablesReLoad(statement);
				LoggerUtil.debug("database exist......");
			}
			
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
