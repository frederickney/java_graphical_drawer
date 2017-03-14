SRC=src/sources/*.java src/sources/application/*.java src/sources/geom2D/*.java src/sources/reader/*.java
OBJECT=bin/sources/*.class bin/sources/application/*.class bin/sources/geom2D/*.class bin/sources/reader/*.class
SRCPATH=src
PACKAGE=sources
BINPATH=bin
DOCPATH=javadoc
MANIFEST=manifest.mf
EXEC=run_tp5.jar


build: $(EXEC)

run: build
	java -jar $(EXEC) $(param)
	
$(EXEC): $(OBJECT)
	@echo -e "Generating $@..."
	@jar cvfm $(EXEC) $(MANIFEST) -C $(BINPATH) .
	@echo -e "[\033[0;32mDONE\033[0m]"

$(OBJECT): $(SRC)
	@echo -e "Creating $@..."
	@mkdir -p $(BINPATH) 
	@javac $< -s $(SRCPATH) -d $(BINPATH) -sourcepath $(SRCPATH)
	@echo -e "[\033[0;32mDONE\033[0m]"

clean:
	@echo "Cleaning..."
	@rm -rf $(BINPATH) $(EXEC)

doc:
	@echo "Generating docs..."
	@mkdir -p $(DOCPATH)
	@javadoc -d $(DOCPATH) -sourcepath $(SRCPATH) -subpackages $(PACKAGE)
	@echo -e "[\033[0;32mDONE\033[0m]"

clean_doc:
	@echo "Cleaning docs..."
	@rm -rf $(DOCPATH)
