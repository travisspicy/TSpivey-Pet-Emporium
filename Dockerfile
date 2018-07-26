
FROM mongo:latest

RUN mkdir -p /data/db2 \
	&& echo "dbpath = /data/db2" > /etc/mongodb.conf \
	&& chown -R mongodb:mongodb /data/db2

COPY /json /data/db2/json
RUN ls /data/db2/json

RUN mongod --fork --logpath /var/log/mongodb.log --dbpath /data/db2 --smallfiles \
	&& mongoimport --jsonArray --db kittycat --collection animals --drop --file /data/db2/json/animal.json \
	&& mongoimport --jsonArray --db kittycat --collection customers --drop --file /data/db2/json/customer.json \
	&& mongoimport --jsonArray --db kittycat --collection employees --drop --file /data/db2/json/employee.json \
	&& mongoimport --jsonArray --db kittycat --collection transactions --drop --file /data/db2/json/transaction.json \
    && mongod --dbpath /data/db2 --shutdown \
    && chown -R mongodb /data/db2

# Make the new dir a VOLUME
VOLUME /data/db2

# Expose the default MongoDB Port
EXPOSE 27018

CMD ["mongod", "--config", "/etc/mongodb.conf", "--smallfiles"]