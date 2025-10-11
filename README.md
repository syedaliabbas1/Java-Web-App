# Patient Data Web Application

A Java-based web application for managing and searching patient data using embedded Tomcat server and JSP technology.

## Overview

This application provides a web interface for viewing, searching, and managing patient information stored in CSV format. Built with Java Servlets and JSP, it demonstrates the Model-View-Controller (MVC) architecture pattern with a custom DataFrame implementation for data manipulation.

## Features

- **Patient List View**: Display all patient records in a tabular format
- **Search Functionality**: Search across all patient data fields with case-insensitive matching
- **Data Management**: Custom DataFrame and Column classes for efficient data handling
- **Responsive UI**: Clean, table-based interface for easy data visualization
- **Error Handling**: Custom 404 and 500 error pages

## Technology Stack

- **Java 21**
- **Apache Tomcat 9.0.45** (Embedded)
- **JSP/Servlet API**
- **Maven** for dependency management
- **Apache Commons CSV** for CSV parsing
- **Jackson Databind** for JSON processing

## Project Structure

```
WebApp/
├── src/main/
│   ├── java/uk/ac/ucl/
│   │   ├── main/
│   │   │   └── Main.java                 # Application entry point
│   │   ├── model/
│   │   │   ├── Column.java               # Column data structure
│   │   │   ├── DataFrame.java            # DataFrame implementation
│   │   │   ├── DataLoader.java           # CSV data loader
│   │   │   ├── Model.java                # Business logic layer
│   │   │   └── ModelFactory.java         # Singleton model access
│   │   └── servlets/
│   │       ├── SearchServlet.java        # Search request handler
│   │       └── ViewPatientListServlet.java # Patient list handler
│   └── webapp/
│       ├── WEB-INF/
│       │   └── web.xml                   # Web app configuration
│       ├── index.html                    # Home page
│       ├── search.html                   # Search interface
│       ├── patientList.jsp               # Patient list view
│       └── searchResult2.jsp             # Search results view
├── data/
│   └── patients100.csv                   # Patient data (100 records)
└── pom.xml                               # Maven configuration
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 21 or higher
- Apache Maven 3.6+

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd WebApp
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn exec:exec
   ```
   
   Alternatively, run the Main class directly:
   ```bash
   java -cp target/classes uk.ac.ucl.main.Main
   ```

4. **Access the application**
   
   Open your browser and navigate to:
   ```
   http://localhost:8080
   ```

## Usage

### Viewing Patient Data

1. From the home page, click "View the Patient ID List"
2. Browse all patient records displayed in a formatted table

### Searching Patient Data

1. Click "Search" from the home page
2. Enter a search term (searches across all fields)
3. View matching results in a filtered table

### Search Functionality

The search feature performs case-insensitive matching across all columns. When a match is found in any field, the entire row is included in the results.

## Data Model

### DataFrame Class

The custom DataFrame implementation provides:
- `addColumn(Column)`: Add a column to the frame
- `getColumnNames()`: Retrieve column names
- `getRowCount()`: Get total number of rows
- `getValue(columnName, row)`: Access specific cell value
- `putValue(columnName, row, value)`: Update cell value
- `addValue(columnName, value)`: Append value to column

### Column Class

Individual columns support:
- `getName()`: Get column name
- `getSize()`: Get number of rows
- `getRowValue(index)`: Retrieve row value
- `setRowValue(index, value)`: Update row value
- `addRowValue(value)`: Append new row

## Configuration

### Port Configuration

Default port is 8080. To change, modify `Main.java`:
```java
tomcat.setPort(8080); // Change to desired port
```

### Data Source

Patient data is loaded from `data/patients100.csv`. To use a different file, update `ModelFactory.java`:
```java
model = new Model("path/to/your/data.csv");
```

## API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/` | GET | Home page |
| `/patientList.html` | GET | Display all patients |
| `/search.html` | GET | Search form |
| `/runsearch.html` | POST | Execute search |

## Building for Production

Create a WAR file for deployment:
```bash
mvn clean package
```

The WAR file will be generated in `war-file/WebApp-1.0-SNAPSHOT.war`

## Error Handling

- **404 Errors**: Custom page not found handler
- **500 Errors**: Internal server error page
- All uncaught exceptions display user-friendly error messages

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Built as part of COMP0004 coursework
- Uses synthetic patient data for demonstration purposes
- Data structure inspired by pandas DataFrame concept

## Contact

For questions or support, please open an issue in the repository.
