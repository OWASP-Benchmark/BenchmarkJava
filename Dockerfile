FROM maven:3.3.3-jdk-8

# Copy OWASP benchmark source code
RUN mkdir /benchmark/
WORKDIR /benchmark/

COPY . /benchmark/

# Build the war file
RUN mvn clean compile verify

# Expose the Benchmark port
EXPOSE 8443

# Run the compiled stuff
ENTRYPOINT mvn verify cargo:run -Pdeploy
