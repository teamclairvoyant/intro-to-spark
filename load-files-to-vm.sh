# Upload needed files to VM

scp -r -P 2222 spark_workshop_codebase cloudera@localhost:/home/cloudera/spark-workshop/
scp -r -P 2222 spark_workshop_data cloudera@localhost:/home/cloudera/spark-workshop/
scp -P 2222 load-data-into-hdfs.sh cloudera@localhost:/home/cloudera/spark-workshop/