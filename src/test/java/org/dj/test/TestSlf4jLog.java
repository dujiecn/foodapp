package org.dj.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSlf4jLog {
	@Test
	public void test() {
			Logger log = LoggerFactory.getLogger(TestSlf4jLog.class);
			log.trace("trace===");
			log.debug("debug==={}","wo");
			log.info("info=====");
			log.warn("warn=====");
			log.error("error===");
		}
}
