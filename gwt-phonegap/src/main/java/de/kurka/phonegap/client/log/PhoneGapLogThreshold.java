/*
 * Copyright 2011 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.kurka.phonegap.client.log;

import java.util.logging.Level;

/**
 * @author Daniel Kurka
 * 
 */
public interface PhoneGapLogThreshold {

	public Level getLevel();

	public class Off implements PhoneGapLogThreshold {

		@Override
		public Level getLevel() {
			return Level.OFF;
		}

	}

	public class Severe implements PhoneGapLogThreshold {

		@Override
		public Level getLevel() {
			return Level.SEVERE;
		}

	}

	public class Warning implements PhoneGapLogThreshold {

		@Override
		public Level getLevel() {
			return Level.WARNING;
		}

	}

	public class Info implements PhoneGapLogThreshold {

		@Override
		public Level getLevel() {
			return Level.INFO;
		}

	}

	public class Config implements PhoneGapLogThreshold {

		@Override
		public Level getLevel() {
			return Level.CONFIG;
		}

	}

	public class Fine implements PhoneGapLogThreshold {

		@Override
		public Level getLevel() {
			return Level.FINE;
		}

	}

	public class Finer implements PhoneGapLogThreshold {

		@Override
		public Level getLevel() {
			return Level.FINER;
		}

	}

	public class Finest implements PhoneGapLogThreshold {

		@Override
		public Level getLevel() {
			return Level.FINEST;
		}

	}

	public class All implements PhoneGapLogThreshold {

		@Override
		public Level getLevel() {
			return Level.ALL;
		}

	}

}
