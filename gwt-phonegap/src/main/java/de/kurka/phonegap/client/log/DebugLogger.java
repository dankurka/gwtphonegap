package de.kurka.phonegap.client.log;

public interface DebugLogger {

	public abstract boolean isAvailable() ;

	public abstract void info(String message) ;

	public abstract void warn(String message) ;

	public abstract void error(String message) ;

}