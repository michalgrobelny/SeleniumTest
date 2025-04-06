# Base Jenkins image
FROM jenkins/jenkins:lts

# Switch to root to install packages
USER root

# Set environment variables
ENV JAVA_VERSION=17

# Install dependencies, Java, Maven
RUN apt-get update && \
    apt-get install -y wget gnupg2 software-properties-common curl unzip && \
    apt-get install -y openjdk-17-jdk maven libxss1 libappindicator3-1 libasound2 libatk-bridge2.0-0 libnspr4 libnss3 libx11-xcb1 libxcomposite1 libxcursor1 libxdamage1 libxrandr2 xdg-utils fonts-liberation libu2f-udev && \
    apt-get clean

# Copy Chrome and Chromedriver from local context into image
COPY chromedriver /usr/local/bin/chromedriver


# Set permissions
RUN chmod +x /usr/local/bin/chromedriver

# Confirm versions
RUN java -version
RUN mvn -version
RUN chromedriver --version

# COPY chrome /opt/google/chrome
# RUN ln -s /opt/google/chrome/google-chrome /usr/bin/google-chrome
# RUN google-chrome --version

RUN wget -q http://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_135.0.7049.52-1_amd64.deb
RUN apt-get -y update
RUN apt-get install -y ./google-chrome-stable_135.0.7049.52-1_amd64.deb

RUN google-chrome --version

# Set back to Jenkins user
USER jenkins