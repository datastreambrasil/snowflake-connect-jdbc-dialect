package br.com.datastreambrasil.connect.dialect.snowflake;

class JdbcDriverVersionException extends RuntimeException {
  public JdbcDriverVersionException(Version actual, Version minimalRecommended) {
    super(
        String.format(
            "Using driver in version %s must be forced - recommended driver version should be at least %s",
            actual, minimalRecommended));
  }
}
