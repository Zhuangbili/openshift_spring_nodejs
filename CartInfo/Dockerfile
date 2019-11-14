FROM node:10
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . .
RUN echo "now building..."
RUN npm install
CMD [ "npm", "start"]
