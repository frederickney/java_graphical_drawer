SRCPATH=src
BINPATH=bin
PACKAGE=sources
DOCPATH=javadoc
MANIFEST=manifest.mf
EXEC=run_tp5.jar
LOGO=logo
SRC=${SRCPATH}/${PACKAGE}/Exe.java
OBJECT=$(subst ${SRCPATH}/,${BINPATH}/,$(SRC))
OBJ=$(subst .java,.class,$(OBJECT))

all: doc build

build: $(EXEC)

run: $(EXEC)
	java -jar $(EXEC) $(param)
	
$(EXEC): $(OBJ) $(BINPATH)/$(LOGO)
	@echo -e "Generating $@..."
	@jar cvfm $(EXEC) $(MANIFEST) -C $(BINPATH) .
	@echo -e "[\033[0;32mDONE\033[0m]"

$(OBJ): $(SRC)
	@echo -e "Compiling java file(s)..."
	@mkdir -p $(BINPATH) 
	@javac $< -s $(SRCPATH) -d $(BINPATH) -sourcepath $(SRCPATH)
	@echo -e "[\033[0;32mDONE\033[0m]"

$(BINPATH)/$(LOGO): $(LOGO)
	@echo "Adding logos..."
	@mkdir -p $(BINPATH)/$(LOGO)
	@cp -rf $ $(LOGO)/* $(BINPATH)/$(LOGO)/
	@echo -e "[\033[0;32mDONE\033[0m]"


clean:
	@echo "Removing jar file..."
	@rm -rf $(EXEC)
	@echo "Cleaning generated class file(s)..."
	@rm -rf $(BINPATH)
	@echo "Cleaning docs..."
	@rm -rf $(DOCPATH)

doc:
	@echo "Generating docs..."
	@mkdir -p $(DOCPATH)
	@javadoc -d $(DOCPATH) -sourcepath $(SRCPATH) -subpackages $(PACKAGE) >> /dev/null
	@echo -e "[\033[0;32mDONE\033[0m]"

