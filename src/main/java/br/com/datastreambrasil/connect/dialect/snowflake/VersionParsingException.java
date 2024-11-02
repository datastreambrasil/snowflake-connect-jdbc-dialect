package br.com.datastreambrasil.connect.dialect.snowflake;

class VersionParsingException extends RuntimeException {
  public VersionParsingException(String rawVersion, Exception cause) {
    super("Version " + rawVersion + "does not follow {major}.{minor}.{patch} format", cause);
  }

  public VersionParsingException(String rawVersion) {
    this(rawVersion, null);
  }
}
