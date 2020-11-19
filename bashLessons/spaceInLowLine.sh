#!/bin/bash

echo "what directory to check?"
read directory
	find $directory -type f | while read file; do
	if [[ "$file" = *[[:space:]]* ]]; then
	mv "$file" `echo $file | tr ' ' '_'`
	fi;
	done
