# Upload needed files to VM

ssh -n -p 2222 cloudera@localhost "
	mkdir -p /home/cloudera/spark-workshop/
"
scp -r -P 2222 spark_workshop_codebase cloudera@localhost:/home/cloudera/spark-workshop
scp -r -P 2222 spark-workshop-data cloudera@localhost:/home/cloudera/spark-workshop
scp -P 2222 load-data-into-hdfs.sh cloudera@localhost:/home/cloudera/spark-workshop/
ssh -n -p 2222 cloudera@localhost "
	cd /home/cloudera/spark-workshop
	find . -name \"*.iml\" -type f -delete
    find . -name \".DS_Store\" -type f -delete
"