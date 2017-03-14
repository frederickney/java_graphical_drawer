SRC=src/sources/*.java src/sources/application/*.java src/sources/geom2D/*.java src/sources/reader/*.java
OBJECT=bin/sources/*.class bin/sources/application/*.class bin/sources/geom2D/*.class bin/sources/reader/*.class
SRCPATH=src
PACKAGE=sources
BINPATH=bin
DOCPATH=javadoc
MANIFEST=manifest.mf
EXEC=run_tp5.jar

all: doc build

build: $(EXEC)

run: $(EXEC)
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
	@echo "Removing jar file..."
	@rm -rf $(EXEC)
	@echo "Cleaning generated class files..."
	@rm -rf $(BINPATH)
	@echo "Cleaning docs..."
	@rm -rf $(DOCPATH)

doc:
	@echo "Generating docs..."
	@mkdir -p $(DOCPATH)
	@javadoc -d $(DOCPATH) -sourcepath $(SRCPATH) -subpackages $(PACKAGE)
	@echo -e "[\033[0;32mDONE\033[0m]"

