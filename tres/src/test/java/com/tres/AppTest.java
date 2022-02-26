package com.tres;

import java.util.List;

import com.tres.entity.Schedule;
import com.tres.service.SearchService;
import org.junit.Test;

public class AppTest {

	public AppTest() {

	}

	@Test
	public void searchServiceTest() throws Exception {
		SearchService search = new SearchService();

		System.out.println(search.convertDateToWeekDay("27-2-2022"));
	}
}
